package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.HbInfo.BundleInfo;
import com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl;
import com.tencent.mobileqq.utils.StringUtil;
import cooperation.qwallet.QwUtils;
import org.json.JSONObject;

public class HbBusiUtils
{
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 == 1)
    {
      paramInt1 = i;
      if (paramInt2 == 1) {
        paramInt1 = 0;
      }
      return paramInt1;
    }
    return RedPacketManagerImpl.getEnterType(paramInt1);
  }
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.replaceAll("[\\u4e00-\\u9fa5]", "aa").length() - paramString.length();
    }
    return 0;
  }
  
  public static String a(int paramInt, HbInfo.BundleInfo paramBundleInfo, ConfigLogic paramConfigLogic, String paramString)
  {
    int i = 2;
    if (paramBundleInfo != null)
    {
      int j = QwUtils.a(paramBundleInfo.bus_type, 2);
      i = j;
      if (!StringUtil.a(paramBundleInfo.biz_params)) {
        try
        {
          String str = new JSONObject(paramBundleInfo.biz_params).optString("memo", "");
          paramBundleInfo = str;
          if (a(str) >= 18)
          {
            paramBundleInfo = new StringBuilder();
            paramBundleInfo.append(str.substring(0, 18));
            paramBundleInfo.append("...");
            paramBundleInfo = paramBundleInfo.toString();
          }
          boolean bool = StringUtil.a(paramBundleInfo);
          i = j;
          if (!bool) {
            return paramBundleInfo;
          }
        }
        catch (Exception paramBundleInfo)
        {
          paramBundleInfo.printStackTrace();
          i = j;
        }
      }
    }
    return paramConfigLogic.a(paramInt, i, paramString);
  }
  
  public static String a(EditText paramEditText)
  {
    String str = paramEditText.getText().toString();
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = paramEditText.getHint();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramEditText = paramEditText.getResources().getString(R.string.L);
      } else {
        paramEditText = ((CharSequence)localObject).toString();
      }
      localObject = paramEditText;
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (!bool) {
      str = paramString.replaceAll("[\\u4e00-\\u9fa5,，。、 ]", "");
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbBusiUtils
 * JD-Core Version:    0.7.0.1
 */