package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentPgcVideo
  extends ComponentContentBigImageVideo
{
  public ComponentContentPgcVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentPgcVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentPgcVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560137, this, true);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
    {
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      label137:
      Object localObject2;
      if ((localObject3 != null) && (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject3).mJsonVideoList)))
      {
        int j = 0;
        int i;
        int k;
        try
        {
          Object localObject1 = new JSONObject(((AbsBaseArticleInfo)localObject3).mJsonVideoList).optJSONArray("videos");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            localObject1 = ((JSONArray)localObject1).optJSONObject(0);
            if (localObject1 != null)
            {
              i = ((JSONObject)localObject1).optInt("height");
              try
              {
                k = ((JSONObject)localObject1).optInt("width");
                j = k;
              }
              catch (JSONException localJSONException1)
              {
                break label137;
              }
            }
          }
          i = 0;
        }
        catch (JSONException localJSONException2)
        {
          i = 0;
          QLog.d("ComponentContentUgcVideo", 2, localJSONException2, new Object[0]);
        }
        if ((j != 0) && (i != 0))
        {
          localObject2 = getLayoutParams();
          Object localObject4 = getResources().getDisplayMetrics();
          k = Math.min(((DisplayMetrics)localObject4).widthPixels, ((DisplayMetrics)localObject4).heightPixels);
          int m = AIOUtils.b(12.0F, getResources());
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
          boolean bool = RIJFeedsType.a(j, i) ^ true;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("isHorizontalScreen ");
          localStringBuilder.append(bool);
          QLog.d("ComponentContentPgcVideo", 2, localStringBuilder.toString());
          if (bool)
          {
            j = k - m * 2;
            i = j * 9 / 16;
          }
          else if (((AbsBaseArticleInfo)localObject3).mChannelID == 0L)
          {
            j = ReadInJoyDisplayUtils.a(k, getResources());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("main feeds | ivWidth is ");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append("; ivHeight is ");
            ((StringBuilder)localObject3).append(j);
            QLog.d("ComponentContentPgcVideo", 2, ((StringBuilder)localObject3).toString());
            i = j;
          }
          else
          {
            i = k - m * 2;
            j = (i + 9) / 2;
            i /= 3;
            i *= 2;
          }
          ((ViewGroup.LayoutParams)localObject4).width = j;
          ((ViewGroup.LayoutParams)localObject4).height = i;
          ((ViewGroup.LayoutParams)localObject2).width = j;
          ((ViewGroup.LayoutParams)localObject2).height = i;
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("imageParams.width is ");
          ((StringBuilder)localObject2).append(((ViewGroup.LayoutParams)localObject4).width);
          ((StringBuilder)localObject2).append("; imageParams.height is ");
          ((StringBuilder)localObject2).append(((ViewGroup.LayoutParams)localObject4).height);
          QLog.d("ComponentContentPgcVideo", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        if (localObject3 == null)
        {
          localObject2 = "";
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((AbsBaseArticleInfo)localObject3).mJsonVideoList);
          ((StringBuilder)localObject2).append("  ");
          ((StringBuilder)localObject2).append(localObject3);
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        QLog.d("ComponentContentUgcVideo", 2, (String)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentPgcVideo
 * JD-Core Version:    0.7.0.1
 */