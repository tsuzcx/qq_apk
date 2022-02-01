package com.tencent.mobileqq.kandian.biz.pts.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeVideoView;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyVideoView
  extends ViewBase
{
  private int jdField_a_of_type_Int;
  private NativeVideoView jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public ReadInJoyVideoView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView = new NativeVideoView(paramVafContext.getContext());
  }
  
  public NativeVideoView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView;
  }
  
  public void a()
  {
    NativeVideoView localNativeVideoView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView;
    if (localNativeVideoView != null) {
      localNativeVideoView.stop();
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.getComMeasuredWidth();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setBackgroundColor(this.mBackground);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setCoverUrl(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setPlayIconUrl(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setVideoVid(this.c);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setPlayIconSize(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setVideoUrl(this.d);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setVideoBusiType(Integer.parseInt(this.e));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("ReadInJoyVideoView", 2, localNumberFormatException.getMessage());
    }
    refresh();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1009)
    {
      Object localObject;
      if (paramInt != 1148)
      {
        if (paramInt != 1151)
        {
          if (paramInt != 1153) {
            return super.setAttribute(paramInt, paramObject);
          }
        }
        else if (((paramObject instanceof JSONArray)) && (((JSONArray)paramObject).length() == 2)) {
          try
          {
            localObject = ((JSONArray)paramObject).optString(0);
            paramObject = ((JSONArray)paramObject).optString(1);
            this.c = ((String)localObject);
            this.e = paramObject;
            return true;
          }
          catch (NumberFormatException paramObject)
          {
            paramObject.printStackTrace();
            return false;
          }
        }
        if ((paramObject instanceof JSONObject)) {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setReportR5(paramObject.toString());
            paramObject = (JSONObject)paramObject;
            this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setDtPgid(paramObject.optString("dt_pgid"));
            return true;
          }
          catch (Exception paramObject)
          {
            QLog.d("ReadInJoyVideoView", 1, paramObject.getMessage());
            return true;
          }
        }
        return false;
      }
      if ((paramObject instanceof JSONArray))
      {
        localObject = (JSONArray)paramObject;
        if (((JSONArray)localObject).length() == 2)
        {
          paramObject = ((JSONArray)localObject).optString(0);
          localObject = ((JSONArray)localObject).optString(1);
          try
          {
            paramInt = Integer.parseInt(paramObject);
            int i = Integer.parseInt((String)localObject);
            this.jdField_a_of_type_Int = paramInt;
            this.jdField_b_of_type_Int = i;
            return true;
          }
          catch (Exception paramObject)
          {
            paramObject.printStackTrace();
          }
        }
      }
      return true;
    }
    if ((paramObject instanceof BaseArticleInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setArticleInfo((AbsBaseArticleInfo)paramObject);
    }
    return true;
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 1148: 
    case 1151: 
    case 1153: 
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1154: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setAutoPlayMode(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
      return false;
    case 1152: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setPlayMode(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
      return false;
    case 1150: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setPlayIconVisible("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1149: 
      this.jdField_b_of_type_JavaLangString = paramString;
      return true;
    case 1147: 
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setScaleType(Integer.parseInt(paramString));
          return true;
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
        }
      }
      return false;
    case 1146: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setMute("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1145: 
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeVideoView.setLoop("yes".equals(paramString.toLowerCase()));
        return true;
      }
      return false;
    case 1144: 
      this.c = paramString;
      return true;
    case 1143: 
      this.jdField_a_of_type_JavaLangString = paramString;
      return true;
    }
    this.d = paramString;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyVideoView
 * JD-Core Version:    0.7.0.1
 */