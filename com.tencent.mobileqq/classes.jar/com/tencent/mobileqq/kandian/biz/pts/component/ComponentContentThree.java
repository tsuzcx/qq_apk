package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.utils.JSONUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ComponentContentThree
  extends FrameLayout
  implements ComponentInheritView
{
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  List<KandianUrlImageView> jdField_a_of_type_JavaUtilList;
  KandianUrlImageView b;
  KandianUrlImageView c;
  
  public ComponentContentThree(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentThree(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentThree(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560136, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376081));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131369925));
    this.b = ((KandianUrlImageView)paramView.findViewById(2131364396));
    this.c = ((KandianUrlImageView)paramView.findViewById(2131376536));
    this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.b, this.c });
    b();
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramObject);
      setContent(paramObject);
    }
  }
  
  public void b()
  {
    UtilsForComponent.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, true);
    UtilsForComponent.a(getContext(), this.b, true);
    UtilsForComponent.a(getContext(), this.c, true);
    ((LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams()).setMargins(0, 0, AIOUtils.b(1.5F, getResources()), 0);
    ((LinearLayout.LayoutParams)this.b.getLayoutParams()).setMargins(0, 0, AIOUtils.b(1.5F, getResources()), 0);
  }
  
  public void setContent(IReadInJoyModel paramIReadInJoyModel)
  {
    Object localObject2 = paramIReadInJoyModel.a();
    if (localObject2 == null) {
      return;
    }
    Object localObject1;
    if ((((AbsBaseArticleInfo)localObject2).mPictures != null) && (((AbsBaseArticleInfo)localObject2).mPictures.length > 0))
    {
      if ((((AbsBaseArticleInfo)localObject2).mPictures.length >= 1) && (localObject2.mPictures[0] != null)) {
        paramIReadInJoyModel = localObject2.mPictures[0];
      } else {
        paramIReadInJoyModel = ((AbsBaseArticleInfo)localObject2).mSinglePicture;
      }
      if ((((AbsBaseArticleInfo)localObject2).mPictures.length >= 2) && (localObject2.mPictures[1] != null)) {
        localObject1 = localObject2.mPictures[1];
      } else {
        localObject1 = ((AbsBaseArticleInfo)localObject2).mSinglePicture;
      }
      if ((((AbsBaseArticleInfo)localObject2).mPictures.length >= 3) && (localObject2.mPictures[2] != null)) {
        localObject2 = localObject2.mPictures[2];
      } else {
        localObject2 = ((AbsBaseArticleInfo)localObject2).mSinglePicture;
      }
      RIJComponentConfigImage.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { paramIReadInJoyModel, localObject1, localObject2 }), getContext());
      return;
    }
    Object localObject3 = JSONUtils.a(((AbsBaseArticleInfo)localObject2).mJsonPictureList, "pictures");
    if (localObject3 != null)
    {
      if (((JSONArray)localObject3).length() <= 0) {
        return;
      }
      paramIReadInJoyModel = ((JSONArray)localObject3).optJSONObject(0);
      if (paramIReadInJoyModel == null) {
        paramIReadInJoyModel = ((AbsBaseArticleInfo)localObject2).mFirstPagePicUrl;
      } else {
        paramIReadInJoyModel = paramIReadInJoyModel.optString("picture");
      }
      localObject1 = ((JSONArray)localObject3).optJSONObject(1);
      if (localObject1 == null) {
        localObject1 = ((AbsBaseArticleInfo)localObject2).mFirstPagePicUrl;
      } else {
        localObject1 = ((JSONObject)localObject1).optString("picture");
      }
      localObject3 = ((JSONArray)localObject3).optJSONObject(2);
      if (localObject3 == null) {
        localObject2 = ((AbsBaseArticleInfo)localObject2).mFirstPagePicUrl;
      } else {
        localObject2 = ((JSONObject)localObject3).optString("picture");
      }
      RIJComponentConfigImage.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { RIJConvertString2URL.a(paramIReadInJoyModel), RIJConvertString2URL.a((String)localObject1), RIJConvertString2URL.a((String)localObject2) }), getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentThree
 * JD-Core Version:    0.7.0.1
 */