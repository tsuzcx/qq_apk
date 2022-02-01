package com.tencent.mobileqq.weiyun.api;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.weiyun.api.download.IWeiyunSoListener;
import com.tencent.util.Pair;
import java.io.File;

@QAPI(process={"all"})
public abstract interface IWeiyunHelper
  extends QRouteApi
{
  public static final String AID_WY_OPEN_QQ_VIP = "mvip.n.a.zcwy_xht";
  public static final String BROADCAST_ENTER_FILE_ASSIT = "enter_file_assit";
  public static final String BROADCAST_EXIT_FILE_ASSIT = "exit_file_assit";
  public static final int RESULT_CODE_OPEN_VIP = 21;
  public static final String SOURCE_ID = "biz_src_jc_xiaolv";
  public static final String TAG = "Weiyun.AlbumBackup";
  public static final String WEIYUN_PLUGIN_ID = "WeiyunPlugin.apk";
  public static final String pf = "qq.wyhy.khd";
  
  public abstract boolean checkSOExists(Context paramContext);
  
  public abstract void cleanPwdRecord(Context paramContext, long paramLong);
  
  public abstract void clearDefaultUploadDirKey();
  
  public abstract PluginRuntime createRuntime(Context paramContext);
  
  public abstract void downgradePath();
  
  public abstract void downloadSo(Context paramContext, IWeiyunSoListener paramIWeiyunSoListener);
  
  public abstract Pair<Pair<String, String>, Long> genThumbInfo(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract String getDefaultDownloadPath();
  
  public abstract String getDefaultThumbPath();
  
  public abstract String[] getDefaultUploadDirKey();
  
  public abstract String getOpenQQVipH5(String paramString1, String paramString2);
  
  public abstract String getOpenWeiyunBuySpaceH5();
  
  public abstract String getOpenWeiyunVipH5(String paramString1, String paramString2);
  
  public abstract File getUploadSoFile(Context paramContext);
  
  public abstract void notifyEnterFileAssit(Context paramContext);
  
  public abstract void notifyExitFileAssit(Context paramContext);
  
  public abstract void saveDefaultUploadDirKey(String paramString1, String paramString2);
  
  public abstract void shutdownWySystem();
  
  public abstract void startWySystem();
  
  public abstract void upgradePath();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.IWeiyunHelper
 * JD-Core Version:    0.7.0.1
 */