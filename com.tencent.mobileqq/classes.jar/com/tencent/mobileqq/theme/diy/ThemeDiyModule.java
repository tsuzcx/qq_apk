package com.tencent.mobileqq.theme.diy;

import afxa;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import anni;
import bdpc;
import bdpp;
import bdqe;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeDiyModule
{
  private static final String TAG = "ThemeDiyModule";
  private AppInterface app;
  private Context context;
  private int mAlbumPageIndex;
  private SparseArray<String> mPageIndexBgMap = new SparseArray();
  private JSONObject mStyle;
  private ThemeDIYData[] mThemeDIYData = ThemeDIYActivity.getDiyData();
  private bdqe mThemeDiyImpl;
  
  public ThemeDiyModule(Context paramContext, AppInterface paramAppInterface)
  {
    this.context = paramContext;
    this.app = paramAppInterface;
  }
  
  private JSONObject getDiyThemePath(int paramInt, String paramString)
  {
    Object localObject2 = null;
    JSONObject localJSONObject = new JSONObject();
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      try
      {
        localJSONObject.put("bgId", "100");
        return localJSONObject;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    Object localObject3 = ThemeBackground.getSharedPreferences(this.context, this.app.getAccount(), 4).getString(paramString, "null");
    Object localObject1 = "100";
    if ("theme_bg_aio_path".equals(paramString)) {
      localObject3 = afxa.a(this.context, this.app.getAccount(), "");
    }
    paramString = (String)localObject2;
    if (!"null".equals(localObject3))
    {
      paramString = imageFile2Base64((String)localObject3);
      localObject1 = ChatBackgroundManager.d((String)localObject3);
    }
    if (("custom".equals(localObject1)) || ("99".equals(localObject1))) {
      this.mPageIndexBgMap.put(paramInt, localObject3);
    }
    localObject2 = localObject1;
    if ("custom".equals(localObject1)) {
      localObject2 = "99";
    }
    localObject1 = localObject2;
    if ("null".equals(localObject2)) {
      localObject1 = "100";
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("getDiyThemePath id:").append((String)localObject1).append(" path:").append((String)localObject3).append(" base64:");
      if (paramString == null) {
        break label278;
      }
      localObject2 = Integer.valueOf(paramString.length());
    }
    for (;;)
    {
      QLog.i("ThemeDiyModule", 2, localObject2);
      try
      {
        localJSONObject.put("bgId", Integer.parseInt((String)localObject1));
        if (paramString != null)
        {
          localJSONObject.put("bgImg", paramString);
          return localJSONObject;
          label278:
          localObject2 = "null";
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          localNumberFormatException.fillInStackTrace();
          localJSONObject.put("bgId", 100);
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          continue;
          paramString = "";
        }
      }
    }
  }
  
  public static String imageFile2Base64(String paramString)
  {
    int i = 1;
    ByteArrayOutputStream localByteArrayOutputStream;
    int j;
    if ((paramString != null) && (new File(paramString).exists()))
    {
      paramString = BitmapFactory.decodeFile(paramString);
      localByteArrayOutputStream = new ByteArrayOutputStream();
      j = paramString.getWidth() / 180;
      if (j < 1)
      {
        Bitmap localBitmap = ThumbnailUtils.extractThumbnail(paramString, paramString.getWidth() / i, paramString.getHeight() / i);
        localBitmap.compress(Bitmap.CompressFormat.JPEG, 60, localByteArrayOutputStream);
        paramString.recycle();
        localBitmap.recycle();
      }
    }
    for (paramString = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 2);; paramString = null)
    {
      if (paramString != null) {
        return "data:image/jpg;base64," + paramString;
      }
      return "";
      i = j;
      break;
    }
  }
  
  private void saveTheme(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("id");
    if (QLog.isColorLevel()) {
      QLog.i("ThemeDiyModule", 2, "saveTheme  themeId:" + str);
    }
    bdpp.a(str, new ThemeDiyModule.1(this, paramJSONObject, paramString));
  }
  
  private void setDIYData(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt < this.mThemeDIYData.length) && (paramInt >= 0))
    {
      if ((!"100".equals(paramString1)) && (!"99".equals(paramString1)) && (paramString2 != null) && (!new File(paramString2).exists())) {
        break label181;
      }
      this.mThemeDIYData[paramInt].mSaveStatus = 5;
    }
    for (;;)
    {
      if (this.mThemeDIYData[paramInt].tryOnBgBigRD == null) {
        this.mThemeDIYData[paramInt].tryOnBgBigRD = new ResData();
      }
      this.mThemeDIYData[paramInt].tryOnBgBigRD.state = 5;
      this.mThemeDIYData[paramInt].tryOnBgBigRD.id = paramString1;
      this.mThemeDIYData[paramInt].tryOnBgBigRD.path = paramString2;
      if (this.mThemeDIYData[paramInt].tryOnBgBigOrgRD == null) {
        this.mThemeDIYData[paramInt].tryOnBgBigOrgRD = new ResData();
      }
      this.mThemeDIYData[paramInt].tryOnBgBigOrgRD.id = paramString1;
      this.mThemeDIYData[paramInt].tryOnBgBigOrgRD.path = paramString2;
      return;
      label181:
      this.mThemeDIYData[paramInt].mSaveStatus = 0;
      if (QLog.isColorLevel()) {
        QLog.i("ThemeDiyModule", 2, "setDIYData download  id:" + paramString1);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("id", paramString1);
      localBundle.putString("name", String.valueOf(paramInt));
      localBundle.putString("url", paramString2);
      if (this.mThemeDiyImpl != null) {
        this.mThemeDiyImpl.downloadBgPic(paramString3, localBundle);
      }
    }
  }
  
  public void albumCallback(String paramString1, String paramString2)
  {
    Object localObject = "";
    String str = imageFile2Base64(paramString1);
    int i;
    if (str.equals(""))
    {
      i = -1;
      localObject = anni.a(2131713600);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeDiyModule", 2, "albumCallback path:" + paramString1 + " imageBase64:" + str.length());
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("result", i);
        localJSONObject.put("msg", localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("image", str);
        ((JSONObject)localObject).put("bgPath", paramString1);
        ((JSONObject)localObject).put("imageSize", str.length());
        localJSONObject.put("data", localObject);
        this.mPageIndexBgMap.put(this.mAlbumPageIndex, paramString1);
        if (this.mThemeDiyImpl != null) {
          this.mThemeDiyImpl.callJs(paramString2, new String[] { localJSONObject.toString() });
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      i = 0;
    }
  }
  
  public Bundle getAuthReqBundle(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("nowOperate", 16);
    localBundle.putInt("nextOperate", 10);
    localBundle.putString("key_from", "201");
    int i = 0;
    if (i < this.mThemeDIYData.length)
    {
      if (this.mThemeDIYData[i].tryOnBgBigRD != null) {}
      for (String str1 = this.mThemeDIYData[i].tryOnBgBigRD.id;; str1 = "100")
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDiyModule", 2, "backgroundSave, bg save : index = " + i + ",id=" + str1);
        }
        String str2 = str1;
        if (str1.equals("custom")) {
          str2 = "99";
        }
        localBundle.putString(ThemeDIYActivity.BUNDLE_PAGE_KEY[i], str2);
        i += 1;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDiyModule", 2, "backgroundSave to save server2.");
    }
    localBundle.putString("themeId", paramString1);
    localBundle.putString("version", paramString2);
    return localBundle;
  }
  
  public JSONObject getDiyCurThemeInfo()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("styleId", ThemeUtil.getUserCurrentThemeId(null));
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(getDiyThemePath(0, "theme_bg_setting_path_png"));
      localJSONArray.put(getDiyThemePath(1, "theme_bg_message_path_png"));
      localJSONArray.put(getDiyThemePath(2, "theme_bg_aio_path"));
      localJSONArray.put(getDiyThemePath(3, "theme_bg_friend_path_png"));
      localJSONArray.put(getDiyThemePath(4, "theme_bg_dynamic_path_png"));
      localJSONObject2.put("bgInfos", localJSONArray);
      localJSONObject1.put("result", 0);
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public void openAlbum(Intent paramIntent, Activity paramActivity, int paramInt1, int paramInt2)
  {
    this.mAlbumPageIndex = paramInt1;
    Object localObject = new ResSuitData.BgSuit(null);
    ((ResSuitData.BgSuit)localObject).id = "99";
    ((ResSuitData.BgSuit)localObject).resID = 2130846093;
    ((ResSuitData.BgSuit)localObject).name = anni.a(2131713582);
    localObject = DIYThemeUtils.getResData(this.app, (ResSuitData)localObject, 121, ((ResSuitData.BgSuit)localObject).id + "." + paramInt1 + "." + System.currentTimeMillis()).path;
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    paramIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    int m = localRect.width();
    int k = localRect.height();
    int j = m;
    int i = k;
    if (paramInt1 != 2)
    {
      j = m * 3 / 4;
      i = k * 3 / 4;
    }
    PhotoUtils.a(paramIntent, paramActivity, paramActivity.getClass().getName(), localRect.width() * 4 / 5, localRect.height() * 4 / 5, j, i, (String)localObject, paramInt2);
  }
  
  public void saveDiyTheme(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("bgInfos");
    this.mStyle = paramJSONObject.optJSONObject("style");
    if (localJSONArray == null)
    {
      if (this.mThemeDiyImpl != null) {
        this.mThemeDiyImpl.callJs(paramString, new String[] { new bdpc(-1, "bginfos is null").a() });
      }
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < localJSONArray.length()) {
        try
        {
          paramJSONObject = localJSONArray.getJSONObject(i).optString("bgId");
          if ("99".equals(paramJSONObject))
          {
            str = (String)this.mPageIndexBgMap.get(i);
            if (QLog.isColorLevel()) {
              QLog.i("ThemeDiyModule", 2, "saveDiyTheme  bgId:" + paramJSONObject + " bgPath:" + str);
            }
            setDIYData(i, paramJSONObject, str, paramString);
            i += 1;
          }
        }
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject.printStackTrace();
            paramJSONObject = null;
            continue;
            String str = ChatBackgroundManager.a(true, paramJSONObject);
          }
        }
      }
    }
    trySaveDefineImage(paramString);
  }
  
  public void setSpThemeBackground()
  {
    try
    {
      ThemeDIYData[] arrayOfThemeDIYData = this.mThemeDIYData;
      int j = arrayOfThemeDIYData.length;
      int i = 0;
      while (i < j)
      {
        ThemeDIYData localThemeDIYData = arrayOfThemeDIYData[i];
        ThemeDIYActivity.setSpThemeBackground(this.context, this.app.getAccount(), localThemeDIYData);
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyModule", 2, QLog.getStackTraceString(localException));
      }
    }
  }
  
  public void setThemeDiyImpl(bdqe parambdqe)
  {
    this.mThemeDiyImpl = parambdqe;
  }
  
  public void trySaveDefineImage(String paramString)
  {
    if (paramString == null) {}
    label89:
    do
    {
      ThemeDIYData localThemeDIYData;
      String str;
      do
      {
        return;
        ThemeDIYData[] arrayOfThemeDIYData = this.mThemeDIYData;
        int j = arrayOfThemeDIYData.length;
        int i = 0;
        if (i >= j) {
          break;
        }
        localThemeDIYData = arrayOfThemeDIYData[i];
        if (localThemeDIYData.tryOnBgBigRD == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localThemeDIYData.mSaveStatus == 0)
          {
            str = ChatBackgroundManager.a(true, localThemeDIYData.tryOnBgBigRD.id);
            if (!new File(str).exists()) {
              break label89;
            }
            localThemeDIYData.mSaveStatus = 5;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.i("ThemeDiyModule", 2, "RES_DATA_STATE_DEALED saveDiyTheme  bgId:" + localThemeDIYData.tryOnBgBigRD.id + " bgPath:" + str);
      return;
    } while (this.mStyle == null);
    saveTheme(this.mStyle, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDiyModule
 * JD-Core Version:    0.7.0.1
 */