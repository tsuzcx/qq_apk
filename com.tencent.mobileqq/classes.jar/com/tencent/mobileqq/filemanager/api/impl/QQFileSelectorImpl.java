package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsProcessor;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.utils.AlbumConstants;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQFileSelectorImpl
  implements IQQFileSelector
{
  private static final String TAG = "QQFileSelectorImpl";
  QfileFavFileRecordProvider mFavProvider = null;
  
  public void enterCloudFileBrowser(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    paramActivity.startActivityForResult(localIntent, 101);
    paramActivity.overridePendingTransition(2130772006, 2130772007);
  }
  
  public void enterLocalFileBrowserByDevice(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FMLocalFileActivity.class);
    localIntent.putExtra("category", 15);
    localIntent.putExtra("busiType", 5);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("peerType", paramInt);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("STRING_Show_Music_Category", false);
    localIntent.putExtra("STRING_Show_Video_Category", false);
    localIntent.putExtra("STRING_Show_Apk_Category", false);
    localIntent.putExtra("STRING_Show_Pic_Category", false);
    localIntent.putExtra("STRING_SingleSelect", false);
    localIntent.putExtra("max_select_count", 5);
    localIntent.putExtra(AlbumConstants.h, 84);
    localIntent.putExtra("STRING_Show_Within_Suffixs", new String[] { "doc", "docx", "txt", "pdf", "ppt", "pptx", "xls", "xlsx", "bmp", "jpg", "gif", "png" });
    paramActivity.startActivityForResult(localIntent, 84);
  }
  
  public void enterQlinkFromQfav(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("busiType", 10);
    localIntent.putExtra("sendprepare", paramInt1);
    localIntent.putExtra("enterfrom", paramInt2);
    localIntent.putExtra("needRemember", true);
    localIntent.putExtra("qfile_entrance_type_key", 10);
    paramActivity.startActivityForResult(localIntent, 110);
    paramActivity.overridePendingTransition(2130771993, 2130771994);
  }
  
  public void enterQlinkLocalFileBrowser(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("busiType", 1);
    localIntent.putExtra("sendprepare", paramInt1);
    localIntent.putExtra("apautocreate", paramBoolean);
    localIntent.putExtra("enterfrom", paramInt2);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("qlinkselect", true);
    localIntent.putExtra("qfile_entrance_type_key", 20);
    paramActivity.startActivityForResult(localIntent, 106);
    paramActivity.overridePendingTransition(2130771993, 2130771994);
  }
  
  public void enterQlinkRecentFileBrowser(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 6);
    localIntent.putExtra("from_qlink", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 108);
    paramActivity.overridePendingTransition(2130772006, 2130772007);
  }
  
  public void fileChooseLaunchForResult(Activity paramActivity, int paramInt1, int paramInt2, ArrayList<String> paramArrayList)
  {
    FMActivity.a(paramActivity, paramInt1, paramInt2, paramArrayList);
  }
  
  public void free()
  {
    QfileFavFileRecordProvider localQfileFavFileRecordProvider = this.mFavProvider;
    if (localQfileFavFileRecordProvider != null)
    {
      localQfileFavFileRecordProvider.c();
      this.mFavProvider = null;
    }
  }
  
  public QfileFavFileRecordProvider getQfileFavFileRecordProvider(AppRuntime paramAppRuntime)
  {
    if (this.mFavProvider == null)
    {
      this.mFavProvider = new QfileFavFileRecordProvider(paramAppRuntime);
      this.mFavProvider.b();
    }
    return this.mFavProvider;
  }
  
  public void openFileClear(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
    localIntent.putExtra("tab_tab_type", 8);
    localIntent.putExtra("only_show_local_tab", true);
    localIntent.putExtra("max_select_count", 999999);
    ReportController.b(null, "dc00898", "", "", "0X800A0C8", "0X800A0C8", 0, 0, "", "", "", "");
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void openFileSelectorByAIO(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("from_aio", true);
    localIntent.addFlags(536870912);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("peerType", paramInt1);
    localIntent.putExtra("targetUin", paramString1);
    localIntent.putExtra("srcDiscGroup", paramString2);
    localIntent.putExtra("qfile_entrance_type_key", paramInt2);
    if ((paramInt1 == 0) || (paramInt1 == 3000) || (paramInt1 == 1)) {
      localIntent.putExtra("select_file_support_send_docs_file", TencentDocSelectAddDocsProcessor.a().a());
    }
    paramActivity.startActivityForResult(localIntent, 5);
  }
  
  public void openFileSelectorByColorNoteHistory(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, FileAssistantActivity.class);
    localIntent.putExtra("from", "FileAssistant");
    paramContext.startActivity(localIntent);
  }
  
  public void openFileSelectorByDeviceMsg(Activity paramActivity, int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("peerType", paramInt1);
    localIntent.putExtra("tab_tab_type", 5);
    if (paramLong > 0L) {
      localIntent.putExtra("max_select_size", paramLong);
    }
    localIntent.putExtra("smart_device_support_flag", paramInt2);
    paramActivity.startActivityForResult(localIntent, 5);
  }
  
  public void openFileSelectorByDocApiPlugin(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra(TeamWorkConstants.f, true);
    localIntent.addFlags(536870912);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("busiType", 9);
    localIntent.putExtra("peerType", 10006);
    localIntent.putExtra("tab_tab_type", 7);
    localIntent.putExtra("only_show_local_tab", true);
    localIntent.putExtra(TeamWorkConstants.g, paramString);
    localIntent.putExtra("smart_device_support_flag", 8);
    paramActivity.startActivity(localIntent);
  }
  
  public void openFileSelectorByLiteActivity(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qfile_entrance_type_key", 11);
    localIntent.putExtra("select_file_support_send_docs_file", TencentDocSelectAddDocsProcessor.a().a());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void openFileSelectorByLiteAdvance(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, LocalFileBrowserActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("category", 6);
    localIntent.putExtra("bundle", localBundle);
    localIntent.putExtra("localSdCardfile", 0);
    localIntent.putExtra("open_with_qq_images", true);
    paramActivity.startActivityForResult(localIntent, 103);
  }
  
  public void openFileSelectorByPrinter(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FMLocalFileActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("busiType", 5);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_PRINTER_UIN);
    localIntent.putExtra("peerType", 6001);
    localIntent.putExtra("STRING_Show_Music_Category", false);
    localIntent.putExtra("STRING_Show_Video_Category", false);
    localIntent.putExtra("STRING_Show_Apk_Category", false);
    localIntent.putExtra("STRING_Show_Pic_Category", false);
    localIntent.putExtra("STRING_SingleSelect", true);
    localIntent.putExtra("STRING_Show_Within_Suffixs", paramArrayOfString);
    localIntent.putExtra(AlbumConstants.h, paramInt);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void openFileSelectorByPulsPanel(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("peerType", paramInt1);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("smart_device_support_flag", paramInt2);
    localIntent.putExtra("smart_device_switch_tab_flag", paramInt3);
    if (paramLong > 0L) {
      localIntent.putExtra("max_select_size", paramLong);
    }
    paramActivity.startActivityForResult(localIntent, 5);
  }
  
  public void openFileSelectorByQRLogin(Activity paramActivity, String paramString, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    String str = AppConstants.DATALINE_PC_UIN;
    if (QFileAssistantUtils.a()) {
      str = AppConstants.FILE_ASSISTANT_UIN;
    }
    localIntent.putExtra("targetUin", str);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra(paramString, paramLong);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void openFileSelectorByWeiyunBoroadcast(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, FMActivity.class);
    localIntent.putExtra("tab_tab_type", 7);
    localIntent.addFlags(268435456);
    new Bundle().putLong("category", 13L);
    localIntent.putExtra("bundle", paramBundle);
    paramContext.startActivity(localIntent);
  }
  
  public void openFileSelectorForTroopFileBrowser(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramActivity, FMActivity.class);
    localIntent.putExtra("key_check_troop_privilege", true);
    localIntent.putExtra("from_aio", true);
    localIntent.addFlags(536870912);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("peerType", 1);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("qfile_entrance_type_key", 4);
    localIntent.putExtra("srcDiscGroup", paramString);
    localIntent.putExtra("srcDiscGroup", paramString);
    localIntent.putExtra("isTroopFile", true);
    localIntent.putExtra("isOverSpace", paramBoolean2);
    if (paramBoolean1)
    {
      localIntent.putExtra("tab_tab_type", 1);
      localIntent.putExtra("is_from_file_folder", true);
    }
    paramActivity.startActivityForResult(localIntent, 5);
  }
  
  public void openLocalFileBrowserActivity(Context paramContext, String paramString)
  {
    try
    {
      if (new JSONObject(paramString).getInt("showlocalfile") == 1)
      {
        paramString = new Intent(paramContext, LocalFileBrowserActivity.class);
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("category", 23);
          paramString.putExtra("bundle", localBundle);
          paramString.putExtra("localSdCardfile", 0);
          paramContext.startActivity(paramString);
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      return;
    }
    catch (JSONException paramContext) {}
  }
  
  public void openMyFile(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, FileAssistantActivity.class);
    localIntent.putExtra("from", "FileAssistant");
    paramActivity.startActivity(localIntent);
  }
  
  public void startFM(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, FileAssistantActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("from", "FileAssistant");
    localIntent.putExtra("COMEFROMDESK", true);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileSelectorImpl
 * JD-Core Version:    0.7.0.1
 */