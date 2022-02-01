package com.tencent.tbs.reader;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class TbsReaderView
  extends FrameLayout
  implements ITbsReaderCallback
{
  public static final String FILE_READER_BG_CONTENT_COLOR = "file_reader_bg_content_color";
  public static final String FILE_READER_DOWNLOAD_TYPE = "file_reader_download_type";
  public static final String FILE_READER_HIDE_TOOLBAR = "file_reader_tool_bar_hide";
  public static final String FILE_READER_UI_STYLE = "style";
  public static final int FILE_READER_UI_STYLE_QQ = 2;
  public static final String IS_BAR_ANIMATING = "is_bar_animating";
  public static final String IS_BAR_SHOWING = "is_bar_show";
  public static final String IS_INTO_DOWNLOADING = "into_downloading";
  public static final String KEY_FILE_PATH = "filePath";
  public static final String KEY_TEMP_PATH = "tempPath";
  public static final int READER_TYPE_DOWNLOAD_CUSTOM = 1;
  public static final int READER_TYPE_DOWNLOAD_DEFAULT = 0;
  public static final int READER_TYPE_ID_TOOLBAR_CLICK = 2;
  public static final int READER_TYPE_ID_TOOLBAR_CLICK_DOWNLOAD_QB = 5;
  public static final int READER_TYPE_ID_TOOLBAR_CLICK_SHOW_DIALOG = 4;
  public static final int READER_TYPE_ID_TOOLBAR_CLICK_TO_QB = 3;
  public static final int READER_TYPE_ID_TOOLBAR_GET_VIEW = 7;
  public static final int READER_TYPE_ID_TOOLBAR_OPEN_QB = 6;
  public static final int READER_TYPE_ID_TOOLBAR_SHOW = 1;
  public static final String TAG = "TbsReaderView";
  static boolean gInitSdk = false;
  public static String gReaderPackName = "";
  public static String gReaderPackVersion = "";
  TbsReaderView.ReaderCallback mCallBack = null;
  Context mContext = null;
  ReaderPluginPreLoad mPluginPreload = null;
  TbsReaderView.ReaderCallback mReaderCallback = null;
  TbsReaderManager mReaderManager = null;
  
  public TbsReaderView(Context paramContext, TbsReaderView.ReaderCallback paramReaderCallback)
  {
    super(paramContext);
    if ((paramContext instanceof Activity))
    {
      this.mCallBack = paramReaderCallback;
      this.mContext = paramContext;
      return;
    }
    throw new RuntimeException("error: unexpect context(none Activity)");
  }
  
  public static Drawable getResDrawable(Context paramContext, int paramInt)
  {
    return null;
  }
  
  public static String getResString(Context paramContext, int paramInt)
  {
    return "";
  }
  
  public static boolean initSDK(Context paramContext)
  {
    if (!gInitSdk) {
      gInitSdk = TbsFileInterfaceImpl.initEngine(paramContext.getApplicationContext());
    }
    paramContext = new StringBuilder();
    paramContext.append("gInitSdk:");
    paramContext.append(gInitSdk);
    Log.d("TbsReaderView", paramContext.toString());
    return gInitSdk;
  }
  
  public static boolean isSupportExt(Context paramContext, String paramString)
  {
    if (initSDK(paramContext)) {
      return TbsFileInterfaceImpl.canOpenFile(paramString);
    }
    return false;
  }
  
  public void doCommand(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    TbsReaderManager localTbsReaderManager = this.mReaderManager;
    if (localTbsReaderManager != null) {
      localTbsReaderManager.doAction(paramInteger, paramObject1, paramObject2);
    }
  }
  
  public boolean downloadPlugin(String paramString)
  {
    TbsReaderManager localTbsReaderManager = this.mReaderManager;
    boolean bool = false;
    if (localTbsReaderManager == null)
    {
      Log.e("TbsReaderView", "downloadPlugin failed!");
      return false;
    }
    if (this.mPluginPreload == null) {
      this.mPluginPreload = localTbsReaderManager.getPluginPre(this.mContext);
    }
    if (this.mPluginPreload.downloadPlugin(this.mContext, paramString) == 0) {
      bool = true;
    }
    return bool;
  }
  
  boolean initWizard()
  {
    try
    {
      if (this.mReaderManager == null) {
        this.mReaderManager = new TbsReaderManager();
      }
      boolean bool = this.mReaderManager.initReader(getContext(), this);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      label33:
      break label33;
    }
    Log.e("TbsReaderView", "Unexpect null object!");
    return false;
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCallBackAction:");
    ((StringBuilder)localObject).append(paramInteger);
    Log.d("TbsReaderView", ((StringBuilder)localObject).toString());
    localObject = this.mCallBack;
    if (localObject != null) {
      ((TbsReaderView.ReaderCallback)localObject).onCallBackAction(paramInteger, paramObject1, paramObject2);
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    TbsReaderManager localTbsReaderManager = this.mReaderManager;
    if (localTbsReaderManager != null) {
      localTbsReaderManager.onSizeChanged(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
  }
  
  public void onStop()
  {
    Object localObject = this.mPluginPreload;
    if (localObject != null) {
      ((ReaderPluginPreLoad)localObject).destroy();
    }
    this.mPluginPreload = null;
    localObject = this.mReaderManager;
    if (localObject != null)
    {
      ((TbsReaderManager)localObject).destroy();
      this.mReaderManager = null;
    }
    this.mContext = null;
    gInitSdk = false;
  }
  
  public int openFile(Bundle paramBundle)
  {
    if ((this.mReaderManager != null) && (paramBundle != null))
    {
      if (!paramBundle.containsKey("file_reader_top_bar_hide")) {
        paramBundle.putBoolean("file_reader_top_bar_hide", true);
      }
      paramBundle.putInt("windowType", TbsFileInterfaceImpl.FILE_READER_WINDOW_TYPE_VIEW);
      int i = this.mReaderManager.openFileReader(getContext(), paramBundle, this, this);
      if (i != 0) {
        Log.e("TbsReaderView", "OpenFile failed!");
      }
      return i;
    }
    Log.e("TbsReaderView", "init failed!");
    return -1;
  }
  
  public boolean preOpen(String paramString, boolean paramBoolean)
  {
    if (!isSupportExt(this.mContext, paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("not supported by:");
      localStringBuilder.append(paramString);
      Log.e("TbsReaderView", localStringBuilder.toString());
      return false;
    }
    boolean bool2 = initSDK(this.mContext);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool2 = initWizard();
      bool1 = bool2;
      if (paramBoolean)
      {
        bool1 = bool2;
        if (bool2)
        {
          downloadPlugin(paramString);
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  public void userStatistics(String paramString)
  {
    TbsReaderManager localTbsReaderManager = this.mReaderManager;
    if (localTbsReaderManager != null) {
      localTbsReaderManager.doAction(Integer.valueOf(6002), paramString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.reader.TbsReaderView
 * JD-Core Version:    0.7.0.1
 */