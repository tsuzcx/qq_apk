package cooperation.zebra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import axqy;
import bbbx;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.pluginsdk.PluginActivity;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.HashMap;

public class ZebraPluginProxy
{
  public static final String KEY_PHOTOCONST_INIT_ACTIVITY_CLASS_NAME = "PhotoConst.INIT_ACTIVITY_CLASS_NAME";
  public static final String KEY_PHOTOCONST_INIT_ACTIVITY_PACKAGE_NAME = "PhotoConst.INIT_ACTIVITY_PACKAGE_NAME";
  public static final String KEY_PHOTOCONST_IS_CALL_IN_PLUGIN = "PhotoConst.IS_CALL_IN_PLUGIN";
  public static final String KEY_PHOTOCONST_IS_SINGLE_DERECTBACK_MODE = "PhotoConst.IS_SINGLE_DERECTBACK_MODE";
  public static final String KEY_PHOTOCONST_IS_SINGLE_MODE = "PhotoConst.IS_SINGLE_MODE";
  public static final String KEY_PHOTOCONST_MAXUM_SELECTED_NUM = "PhotoConst.MAXUM_SELECTED_NUM";
  public static final String KEY_PHOTOCONST_PLUGIN_APK = "PhotoConst.PLUGIN_APK";
  public static final String KEY_PHOTOCONST_PLUGIN_NAME = "PhotoConst.PLUGIN_NAME";
  public static final String KEY_PHOTOCONST_SINGLE_PHOTO_PATH = "PhotoConst.SINGLE_PHOTO_PATH";
  public static final String KEY_PHOTOCONST_UIN = "PhotoConst.UIN";
  public static final String KEY_TRANSFILE_UTILE_TYPE_PHOTO = "TransfileUtile.TYPE_PHOTO";
  private static HashMap<String, Integer> sConstIntMap = new HashMap();
  private static HashMap<String, String> sConstStringMap = new HashMap();
  
  static
  {
    if (sConstIntMap == null) {
      sConstIntMap = new HashMap();
    }
    if (sConstStringMap == null) {
      sConstStringMap = new HashMap();
    }
    sConstIntMap.put("TransfileUtile.TYPE_PHOTO", Integer.valueOf(1));
    sConstStringMap.put("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    sConstStringMap.put("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    sConstStringMap.put("PhotoConst.IS_CALL_IN_PLUGIN", "PhotoConst.IS_CALL_IN_PLUGIN");
    sConstStringMap.put("PhotoConst.PLUGIN_NAME", "PhotoConst.PLUGIN_NAME");
    sConstStringMap.put("PhotoConst.PLUGIN_APK", "PhotoConst.PLUGIN_APK");
    sConstStringMap.put("PhotoConst.UIN", "PhotoConst.UIN");
    sConstStringMap.put("PhotoConst.MAXUM_SELECTED_NUM", "PhotoConst.MAXUM_SELECTED_NUM");
    sConstStringMap.put("PhotoConst.IS_SINGLE_MODE", "PhotoConst.IS_SINGLE_MODE");
    sConstStringMap.put("PhotoConst.IS_SINGLE_DERECTBACK_MODE", "PhotoConst.IS_SINGLE_DERECTBACK_MODE");
    sConstStringMap.put("PhotoConst.SINGLE_PHOTO_PATH", "PhotoConst.SINGLE_PHOTO_PATH");
  }
  
  public static void backToPhoto(Intent paramIntent, Activity paramActivity)
  {
    PhotoUtils.a(paramIntent, paramActivity);
  }
  
  public static int getConstInt(String paramString)
  {
    if (!sConstIntMap.containsKey(paramString)) {
      throw new RuntimeException("key not found");
    }
    return ((Integer)sConstIntMap.get(paramString)).intValue();
  }
  
  public static String getConstString(String paramString)
  {
    if (!sConstStringMap.containsKey(paramString)) {
      throw new RuntimeException("key not found");
    }
    return (String)sConstStringMap.get(paramString);
  }
  
  public static String md5_toMD5(String paramString)
  {
    return MD5.toMD5(paramString);
  }
  
  public static void onSendResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean)
  {
    PhotoUtils.a(paramActivity, paramInt1, paramInt2, paramIntent, paramBoolean);
  }
  
  public static void reportController_reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    axqy.b(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
  
  public static void sendPhoto(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    PhotoUtils.a(paramActivity, paramIntent, paramArrayList, 0, paramBoolean);
  }
  
  public static void sendPhotoForPhotoPlus(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    PhotoUtils.a(paramActivity, paramIntent, paramArrayList);
  }
  
  public static void startPhotoList(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("enter_from", 7);
      localIntent.setClassName("com.tencent.mobileqq", NewPhotoListActivity.class.getName());
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      paramActivity.startActivity(localIntent);
      if ((paramActivity instanceof PluginActivity))
      {
        bbbx.a(((PluginActivity)paramActivity).getOutActivity(), false, true);
        return;
      }
      bbbx.a(paramActivity, false, true);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.zebra.ZebraPluginProxy
 * JD-Core Version:    0.7.0.1
 */