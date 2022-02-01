package com.tencent.mobileqq.vip.diy;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.jsoninflate.model.ViewModel;
import org.json.JSONObject;

public class ProfileTemplateLikeViewModule
  extends ViewModel
{
  private String a;
  
  public ProfileTemplateLikeViewModule(String paramString1, View paramView, String paramString2)
  {
    super(paramString1, paramView);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString2;
    ((TemplateLikeView)paramView).a(1);
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = -2;
    this.b = a(paramJSONObject.optString("height"));
    paramLayoutParams.width = -2;
    paramLayoutParams.height = -2;
    int i = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramJSONObject.optInt("lpd", 2) / 2);
    int j = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramJSONObject.optInt("rpd", 2) / 2);
    ((TemplateLikeView)this.jdField_a_of_type_AndroidViewView).setContainerLayoutParams(this.jdField_a_of_type_Int, this.b, i, j);
    return paramLayoutParams;
  }
  
  protected URLDrawable a(String paramString, DownloadParams.DecodeHandler paramDecodeHandler)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (!paramString.startsWith("http"))
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        if (this.jdField_a_of_type_JavaLangString.startsWith("http"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(paramString);
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("it have the illegal url prefix=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          QLog.e("JsonInflateViewModel", 1, ((StringBuilder)localObject).toString());
          localObject = paramString;
        }
      }
    }
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mLoadingDrawable = URLDrawableHelperConstants.a;
    paramString.mFailedDrawable = URLDrawableHelperConstants.a;
    paramString.mPlayGifImage = false;
    if (paramDecodeHandler != null) {
      paramString.mMemoryCacheKeySuffix = paramDecodeHandler.toString();
    }
    paramString = URLDrawable.getDrawable((String)localObject, paramString);
    paramString.setDecodeHandler(paramDecodeHandler);
    return paramString;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ("bg".equals(paramString1))
    {
      if ((this.jdField_a_of_type_AndroidViewView instanceof TemplateLikeView)) {
        ((TemplateLikeView)this.jdField_a_of_type_AndroidViewView).setVoteContainerBackground(a(paramString2, null));
      }
    }
    else if ("style".equals(paramString1))
    {
      if ((this.jdField_a_of_type_AndroidViewView instanceof TemplateLikeView)) {
        ((TemplateLikeView)this.jdField_a_of_type_AndroidViewView).a("1".equals(paramString2) ^ true);
      }
    }
    else {
      super.a(paramString1, paramString2);
    }
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ProfileTemplateLikeViewModule
 * JD-Core Version:    0.7.0.1
 */