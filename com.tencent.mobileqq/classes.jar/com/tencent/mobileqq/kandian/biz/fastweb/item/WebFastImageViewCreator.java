package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.ImageData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Map;

public class WebFastImageViewCreator
  implements ItemCreator
{
  public static String a(String paramString, ImageData paramImageData)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramImageData.d) {
        return paramString;
      }
      if (!((Boolean)RIJSPUtils.b("sp_native_web_sharpp_pic_switch", Boolean.valueOf(false))).booleanValue()) {
        return paramString;
      }
      if (paramString.contains("fmt=gif"))
      {
        paramImageData.d = false;
        return paramString;
      }
      paramImageData = URLUtil.a(paramString);
      if (paramImageData.containsKey("tp"))
      {
        paramImageData = (String)paramImageData.get("tp");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tp=");
        ((StringBuilder)localObject).append(paramImageData);
        paramString = paramString.replace(((StringBuilder)localObject).toString(), "tp=sharp");
      }
      else if (paramImageData.size() > 0)
      {
        paramImageData = new StringBuilder();
        paramImageData.append(paramString);
        paramImageData.append("&tp=sharp");
        paramString = paramImageData.toString();
      }
      else
      {
        paramImageData = new StringBuilder();
        paramImageData.append(paramString);
        paramImageData.append("?tp=sharp");
        paramString = paramImageData.toString();
      }
      paramImageData = FastWebModule.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sharpSupport, url : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d(paramImageData, 2, ((StringBuilder)localObject).toString());
      localObject = paramString;
    }
    return localObject;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("tp=sharp");
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new WebFastImageViewCreator.ImageViewHolder(LayoutInflater.from(paramContext).inflate(2131626236, null), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.aP == 3;
  }
  
  public int b(BaseData paramBaseData)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastImageViewCreator
 * JD-Core Version:    0.7.0.1
 */