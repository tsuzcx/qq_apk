package com.tencent.mobileqq.vas.theme.diy;

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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.theme.JSONResult;
import com.tencent.mobileqq.vas.theme.ThemeIPCModule;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeDiyModule
{
  public static String[] a;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ThemeDiyModule.ThemeDiyImpl jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule$ThemeDiyImpl;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private ThemeDIYData[] jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData = a();
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "pageDrawer", "pageMessage", "pageAIO", "pageFriend", "pageDynamic" };
  }
  
  public ThemeDiyModule(Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private static String a(String paramString)
  {
    Object localObject;
    if ((paramString != null) && (new File(paramString).exists()))
    {
      paramString = BitmapFactory.decodeFile(paramString);
      localObject = new ByteArrayOutputStream();
      int j = paramString.getWidth() / 180;
      int i = j;
      if (j < 1) {
        i = 1;
      }
      Bitmap localBitmap = ThumbnailUtils.extractThumbnail(paramString, paramString.getWidth() / i, paramString.getHeight() / i);
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 60, (OutputStream)localObject);
      paramString.recycle();
      localBitmap.recycle();
      paramString = Base64.encodeToString(((ByteArrayOutputStream)localObject).toByteArray(), 2);
    }
    else
    {
      paramString = null;
    }
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("data:image/jpg;base64,");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  private JSONObject a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = null;
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      try
      {
        localJSONObject.put("bgId", "100");
        return localJSONObject;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return localJSONObject;
      }
    }
    Object localObject1 = ThemeBackground.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), 4);
    String str2 = "null";
    String str1 = ((SharedPreferences)localObject1).getString(paramString, "null");
    if ("theme_bg_aio_path".equals(paramString)) {
      str1 = ChatBackgroundUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "");
    }
    if (!"null".equals(str1))
    {
      paramString = a(str1);
      localObject1 = ChatBackgroundUtil.b(str1);
    }
    else
    {
      localObject1 = "100";
      paramString = (String)localObject2;
    }
    if (("custom".equals(localObject1)) || ("99".equals(localObject1))) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, str1);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDiyThemePath id:");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" path:");
      localStringBuilder.append(str1);
      localStringBuilder.append(" base64:");
      localObject2 = str2;
      if (paramString != null) {
        localObject2 = Integer.valueOf(paramString.length());
      }
      localStringBuilder.append(localObject2);
      QLog.i("ThemeDiyModule", 2, localStringBuilder.toString());
    }
    try
    {
      localJSONObject.put("bgId", Integer.parseInt((String)localObject1));
    }
    catch (JSONException paramString) {}catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.fillInStackTrace();
      localJSONObject.put("bgId", 100);
    }
    for (;;)
    {
      localJSONObject.put("bgImg", paramString);
      return localJSONObject;
      paramString.printStackTrace();
      return localJSONObject;
      if (paramString == null) {
        paramString = "";
      }
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData.length) && (paramInt >= 0))
    {
      if ((!"100".equals(paramString1)) && (!"99".equals(paramString1)) && (paramString2 != null) && (!new File(paramString2).exists()))
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].e = 0;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setDIYData download  id:");
          ((StringBuilder)localObject).append(paramString1);
          QLog.i("ThemeDiyModule", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("id", paramString1);
        ((Bundle)localObject).putString("name", String.valueOf(paramInt));
        ((Bundle)localObject).putString("url", paramString2);
        ThemeDiyModule.ThemeDiyImpl localThemeDiyImpl = this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule$ThemeDiyImpl;
        if (localThemeDiyImpl != null) {
          localThemeDiyImpl.downloadBgPic(paramString3, (Bundle)localObject);
        }
      }
      else
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].e = 5;
      }
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData = new ResData();
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_Int = 5;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData.c = paramString2;
      if (this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData == null) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData = new ResData();
      }
      this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[paramInt].jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.c = paramString2;
    }
  }
  
  public static void a(Context paramContext, String paramString, ThemeDIYData paramThemeDIYData)
  {
    if (paramThemeDIYData == null)
    {
      QLog.e("ThemeDiyModule", 1, "sData is null");
      return;
    }
    if ((paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData != null) && (paramThemeDIYData.jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData != null) && (!"100".equals(paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString)))
    {
      ThemeBackground.a(paramContext, paramThemeDIYData.jdField_a_of_type_JavaLangString, paramString, paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.c, paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.d, paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString, "", 1, null, true);
      if (!paramThemeDIYData.jdField_a_of_type_JavaLangString.equals(paramThemeDIYData.jdField_b_of_type_JavaLangString)) {
        if ((paramThemeDIYData.jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData != null) && (paramThemeDIYData.jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_Int == 5)) {
          ThemeBackground.a(paramContext, paramThemeDIYData.jdField_b_of_type_JavaLangString, paramString, paramThemeDIYData.jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData.c, paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.d, paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString, "", 1, null, true);
        } else {
          ThemeBackground.a(paramContext, paramThemeDIYData.jdField_b_of_type_JavaLangString, paramString, paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.c, paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.d, paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString, "", 1, null, true);
        }
      }
      if (paramThemeDIYData.d == 2) {
        ChatBackgroundUtil.a(paramContext, paramString, null, paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.c);
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSpThemeBackground sData.tryOnBgBigOrgRD=");
        localStringBuilder.append(paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData);
        localStringBuilder.append(", sData.tryOnBgBigRD=");
        localStringBuilder.append(paramThemeDIYData.jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData);
        localStringBuilder.append(", id=");
        String str;
        if (paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData == null) {
          str = "-";
        } else {
          str = paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString;
        }
        localStringBuilder.append(str);
        localStringBuilder.append(", pageIndex:");
        localStringBuilder.append(paramThemeDIYData.d);
        QLog.d("ThemeDiyModule", 2, localStringBuilder.toString());
      }
      ThemeBackground.a(paramContext, paramThemeDIYData.jdField_b_of_type_JavaLangString, paramString, "", "", "", "", 1, null, true);
      if (paramThemeDIYData.d == 2) {
        ChatBackgroundUtil.a(paramContext, paramString, null, "null");
      }
    }
  }
  
  private static ThemeDIYData[] a()
  {
    return new ThemeDIYData[] { new ThemeDIYData(2130846235, "theme_bg_setting_path", 2131166621, "theme_bg_setting_path_png", -50, 0), new ThemeDIYData(2130847698, "theme_bg_message_path", 2131166623, "theme_bg_message_path_png", 50, 1), new ThemeDIYData(2130850371, "theme_bg_aio_path", 0, "theme_bg_aio_path", 0, 2), new ThemeDIYData(2130847698, "theme_bg_friend_path", 2131166623, "theme_bg_friend_path_png", 50, 3), new ThemeDIYData(2130850371, "theme_bg_dynamic_path", 2131166623, "theme_bg_dynamic_path_png", 50, 4) };
  }
  
  private void b(JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("id");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveTheme  themeId:");
      localStringBuilder.append(str);
      QLog.i("ThemeDiyModule", 2, localStringBuilder.toString());
    }
    ThemeIPCModule.a(str, new ThemeDiyModule.1(this, paramJSONObject, paramString));
  }
  
  public Bundle a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("nowOperate", 16);
    localBundle.putInt("nextOperate", 10);
    localBundle.putString("key_from", "201");
    int i = 0;
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData;
      if (i >= localObject1.length) {
        break;
      }
      if (localObject1[i].jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData != null) {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData[i].jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString;
      } else {
        localObject1 = "100";
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("backgroundSave, bg save : index = ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(",id=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("ThemeDiyModule", 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = localObject1;
      if (((String)localObject1).equals("custom")) {
        localObject2 = "99";
      }
      localBundle.putString(jdField_a_of_type_ArrayOfJavaLangString[i], (String)localObject2);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDiyModule", 2, "backgroundSave to save server2.");
    }
    localBundle.putString("themeId", paramString1);
    localBundle.putString("version", paramString2);
    return localBundle;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("styleId", ThemeUtil.getUserCurrentThemeId(null));
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(a(0, "theme_bg_setting_path_png"));
      localJSONArray.put(a(1, "theme_bg_message_path_png"));
      localJSONArray.put(a(2, "theme_bg_aio_path"));
      localJSONArray.put(a(3, "theme_bg_friend_path_png"));
      localJSONArray.put(a(4, "theme_bg_dynamic_path_png"));
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
  
  public void a()
  {
    try
    {
      ThemeDIYData[] arrayOfThemeDIYData = this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData;
      int j = arrayOfThemeDIYData.length;
      int i = 0;
      while (i < j)
      {
        ThemeDIYData localThemeDIYData = arrayOfThemeDIYData[i];
        a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), localThemeDIYData);
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
  
  public void a(Intent paramIntent, Activity paramActivity, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    Object localObject1 = new ResSuitData.BgSuit(null);
    ((ResSuitData.BgSuit)localObject1).jdField_b_of_type_JavaLangString = "99";
    ((ResSuitData.BgSuit)localObject1).jdField_a_of_type_Int = 2130846281;
    ((ResSuitData.BgSuit)localObject1).c = HardCodeUtil.a(2131714695);
    Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((ResSuitData.BgSuit)localObject1).jdField_b_of_type_JavaLangString);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(".");
    localStringBuilder.append(System.currentTimeMillis());
    localObject1 = DIYThemeUtils.a((AppRuntime)localObject2, (ResSuitData)localObject1, 121, localStringBuilder.toString()).c;
    localObject2 = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
    paramIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    int m = ((Rect)localObject2).width();
    int k = ((Rect)localObject2).height();
    int j = m;
    int i = k;
    if (paramInt1 != 2)
    {
      j = m * 3 / 4;
      i = k * 3 / 4;
    }
    ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).startPhotoListEditForResult(paramIntent, paramActivity, paramActivity.getClass().getName(), ((Rect)localObject2).width() * 4 / 5, ((Rect)localObject2).height() * 4 / 5, j, i, (String)localObject1, paramInt2);
  }
  
  public void a(ThemeDiyModule.ThemeDiyImpl paramThemeDiyImpl)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule$ThemeDiyImpl = paramThemeDiyImpl;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    ThemeDIYData[] arrayOfThemeDIYData = this.jdField_a_of_type_ArrayOfComTencentMobileqqVasThemeDiyThemeDIYData;
    int j = arrayOfThemeDIYData.length;
    int i = 0;
    while (i < j)
    {
      localObject = arrayOfThemeDIYData[i];
      if ((((ThemeDIYData)localObject).jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData != null) && (((ThemeDIYData)localObject).e == 0))
      {
        String str = ChatBackgroundUtil.a(true, ((ThemeDIYData)localObject).jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString);
        if (FileUtils.fileExists(str))
        {
          ((ThemeDIYData)localObject).e = 5;
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("RES_DATA_STATE_DEALED saveDiyTheme  bgId:");
            paramString.append(((ThemeDIYData)localObject).jdField_a_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_JavaLangString);
            paramString.append(" bgPath:");
            paramString.append(str);
            QLog.i("ThemeDiyModule", 2, paramString.toString());
          }
          return;
        }
      }
      i += 1;
    }
    Object localObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (localObject != null) {
      b((JSONObject)localObject, paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    String str = a(paramString1);
    int i;
    Object localObject1;
    if (str.equals(""))
    {
      i = -1;
      localObject1 = HardCodeUtil.a(2131714713);
    }
    else
    {
      localObject1 = "";
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("albumCallback path:");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" imageBase64:");
      ((StringBuilder)localObject2).append(str.length());
      QLog.i("ThemeDiyModule", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("result", i);
      ((JSONObject)localObject2).put("msg", localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("image", str);
      ((JSONObject)localObject1).put("bgPath", paramString1);
      ((JSONObject)localObject1).put("imageSize", str.length());
      ((JSONObject)localObject2).put("data", localObject1);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Int, paramString1);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule$ThemeDiyImpl;
    if (paramString1 != null) {
      paramString1.callJs(paramString2, new String[] { ((JSONObject)localObject2).toString() });
    }
  }
  
  public void a(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("bgInfos");
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject.optJSONObject("style");
    int i = 0;
    if (localJSONArray == null)
    {
      paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyModule$ThemeDiyImpl;
      if (paramJSONObject != null) {
        paramJSONObject.callJs(paramString, new String[] { new JSONResult(-1, "bginfos is null").a() });
      }
      return;
    }
    while (i < localJSONArray.length())
    {
      paramJSONObject = null;
      try
      {
        String str1 = localJSONArray.getJSONObject(i).optString("bgId");
        paramJSONObject = str1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      String str2;
      if ("99".equals(paramJSONObject)) {
        str2 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      } else {
        str2 = ChatBackgroundUtil.a(true, paramJSONObject);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveDiyTheme  bgId:");
        localStringBuilder.append(paramJSONObject);
        localStringBuilder.append(" bgPath:");
        localStringBuilder.append(str2);
        QLog.i("ThemeDiyModule", 2, localStringBuilder.toString());
      }
      a(i, paramJSONObject, str2, paramString);
      i += 1;
    }
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeDiyModule
 * JD-Core Version:    0.7.0.1
 */