package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;

public class TbsReaderView
  extends FrameLayout
{
  public static final String IS_BAR_ANIMATING = "is_bar_animating";
  public static final String IS_BAR_SHOWING = "is_bar_show";
  public static final String IS_INTO_DOWNLOADING = "into_downloading";
  public static final String KEY_FILE_PATH = "filePath";
  public static final String KEY_TEMP_PATH = "tempPath";
  public static final int READER_CHANNEL_DOC_ID = 10965;
  public static final int READER_CHANNEL_PDF_ID = 10834;
  public static final int READER_CHANNEL_PPT_ID = 10833;
  public static final int READER_CHANNEL_TXT_ID = 10835;
  public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
  public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
  public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
  public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
  public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
  public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
  public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
  public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
  public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
  public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
  public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
  public static final String TAG = "TbsReaderView";
  static boolean gInitSdk = false;
  public static String gReaderPackName = "";
  public static String gReaderPackVersion = "";
  TbsReaderView.ReaderCallback mCallBack = null;
  Context mContext = null;
  TbsReaderView.ReaderCallback mReaderCallback = null;
  Object mTbsReader = null;
  ReaderWizard mWizard = null;
  
  public TbsReaderView(Context paramContext, TbsReaderView.ReaderCallback paramReaderCallback)
  {
    super(paramContext.getApplicationContext());
    if (!(paramContext instanceof Activity)) {
      throw new RuntimeException("error: unexpect context(none Activity)");
    }
    this.mCallBack = paramReaderCallback;
    this.mContext = paramContext;
    this.mReaderCallback = new TbsReaderView.1(this);
  }
  
  public static Drawable getResDrawable(Context paramContext, int paramInt)
  {
    Drawable localDrawable = null;
    if (initSDK(paramContext)) {
      localDrawable = ReaderWizard.getResDrawable(paramInt);
    }
    return localDrawable;
  }
  
  public static String getResString(Context paramContext, int paramInt)
  {
    String str = "";
    if (initSDK(paramContext)) {
      str = ReaderWizard.getResString(paramInt);
    }
    return str;
  }
  
  static boolean initSDK(Context paramContext)
  {
    if (!gInitSdk)
    {
      SDKEngine.getInstance(true).init(paramContext.getApplicationContext(), true, false, null);
      gInitSdk = SDKEngine.getInstance(false).isTbsAvailable();
    }
    return gInitSdk;
  }
  
  public static boolean isSupportExt(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (initSDK(paramContext))
    {
      bool1 = bool2;
      if (ReaderWizard.isSupportCurrentPlatform(paramContext))
      {
        bool1 = bool2;
        if (ReaderWizard.isSupportExt(paramString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void doCommand(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    if ((this.mWizard != null) && (this.mTbsReader != null)) {
      this.mWizard.doCommand(this.mTbsReader, paramInteger, paramObject1, paramObject2);
    }
  }
  
  public boolean downloadPlugin(String paramString)
  {
    if (this.mTbsReader == null)
    {
      Log.e("TbsReaderView", "downloadPlugin failed!");
      return false;
    }
    return this.mWizard.checkPlugin(this.mTbsReader, this.mContext, paramString, true);
  }
  
  boolean initWizard()
  {
    boolean bool = false;
    try
    {
      if (this.mWizard == null) {
        this.mWizard = new ReaderWizard(this.mReaderCallback);
      }
      if (this.mTbsReader == null) {
        this.mTbsReader = this.mWizard.getTbsReader();
      }
      if (this.mTbsReader != null) {
        bool = this.mWizard.initTbsReader(this.mTbsReader, this.mContext);
      }
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("TbsReaderView", "Unexpect null object!");
    }
    return false;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2)
  {
    if ((this.mWizard != null) && (this.mTbsReader != null)) {
      this.mWizard.onSizeChanged(this.mTbsReader, paramInt1, paramInt2);
    }
  }
  
  public void onStop()
  {
    if (this.mWizard != null)
    {
      this.mWizard.destroy(this.mTbsReader);
      this.mTbsReader = null;
    }
    this.mContext = null;
    gInitSdk = false;
  }
  
  public void openFile(Bundle paramBundle)
  {
    boolean bool2 = true;
    if ((this.mTbsReader == null) || (paramBundle == null))
    {
      Log.e("TbsReaderView", "init failed!");
      return;
    }
    boolean bool3 = MttLoader.isBrowserInstalledEx(this.mContext);
    if (!MttLoader.isBrowserInstalled(this.mContext))
    {
      bool1 = true;
      label43:
      paramBundle.putBoolean("browser6.0", bool1 | bool3);
      bool3 = MttLoader.isGreatBrowserVer(this.mContext, 6101625L, 610000L);
      if (MttLoader.isBrowserInstalled(this.mContext)) {
        break label126;
      }
    }
    label126:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBundle.putBoolean("browser6.1", bool3 | bool1);
      if (this.mWizard.openFile(this.mTbsReader, this.mContext, paramBundle, this)) {
        break;
      }
      Log.e("TbsReaderView", "OpenFile failed!");
      return;
      bool1 = false;
      break label43;
    }
  }
  
  public boolean preOpen(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (!isSupportExt(this.mContext, paramString))
    {
      Log.e("TbsReaderView", "not supported by:" + paramString);
      return false;
    }
    boolean bool3 = initSDK(this.mContext);
    boolean bool1 = bool3;
    if (bool3)
    {
      bool3 = initWizard();
      bool1 = bool3;
      if (paramBoolean)
      {
        bool1 = bool3;
        if (bool3)
        {
          paramBoolean = bool2;
          if (Apn.getApnType(this.mContext) == 3) {
            paramBoolean = true;
          }
          return this.mWizard.checkPlugin(this.mTbsReader, this.mContext, paramString, paramBoolean);
        }
      }
    }
    return bool1;
  }
  
  public void userStatistics(String paramString)
  {
    if (this.mWizard != null) {
      this.mWizard.userStatistics(this.mTbsReader, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsReaderView
 * JD-Core Version:    0.7.0.1
 */