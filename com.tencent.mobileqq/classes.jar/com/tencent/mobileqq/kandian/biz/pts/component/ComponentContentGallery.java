package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.JSONUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.util.DisplayUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ComponentContentGallery
  extends FrameLayout
  implements ComponentInheritView
{
  private float jdField_a_of_type_Float = 1.5F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  private List<KandianUrlImageView> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private KandianUrlImageView b;
  private KandianUrlImageView c;
  private KandianUrlImageView d;
  private KandianUrlImageView e;
  private KandianUrlImageView f;
  private KandianUrlImageView g;
  private KandianUrlImageView h;
  private KandianUrlImageView i;
  
  public ComponentContentGallery(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private Pair<Integer, Integer> a()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int j = localResources.getDisplayMetrics().widthPixels;
    int k;
    if (this.jdField_a_of_type_Boolean)
    {
      j = (j - AIOUtils.b(this.jdField_a_of_type_Float * 2.0F, localResources) - AIOUtils.b(22.0F, localResources)) / 3;
      k = j;
    }
    else
    {
      j = (j - AIOUtils.b(this.jdField_a_of_type_Float * 2.0F, localResources)) / 3;
      k = localResources.getDimensionPixelSize(2131298830);
    }
    return new Pair(Integer.valueOf(j), Integer.valueOf(k));
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView)
  {
    Object localObject = a();
    int j = ((Integer)((Pair)localObject).first).intValue();
    int k = ((Integer)((Pair)localObject).second).intValue();
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new LinearLayout.LayoutParams(j, k);
    }
    ((ViewGroup.LayoutParams)localObject).width = j;
    ((ViewGroup.LayoutParams)localObject).height = k;
    paramKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  private void a(List<KandianUrlImageView> paramList, AbsBaseArticleInfo paramAbsBaseArticleInfo, int[] paramArrayOfInt, String paramString)
  {
    if ((paramList != null) && (paramArrayOfInt != null))
    {
      if (paramList.size() != paramArrayOfInt.length) {
        return;
      }
      int j = 0;
      while (j < paramList.size())
      {
        ((KandianUrlImageView)paramList.get(j)).setOnClickListener(new ComponentContentGallery.1(this, paramAbsBaseArticleInfo, paramArrayOfInt[j], paramString, j));
        j += 1;
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
    a();
  }
  
  public int a(JSONArray paramJSONArray, int paramInt)
  {
    int j = paramInt;
    if (paramInt == 5)
    {
      j = paramInt;
      if (paramJSONArray.length() < 9) {
        j = 4;
      }
    }
    paramInt = j;
    if (j == 4)
    {
      paramInt = j;
      if (paramJSONArray.length() < 3) {
        paramInt = 3;
      }
    }
    return paramInt;
  }
  
  public View a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    addView(paramContext);
    return paramContext;
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView);
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
  
  public void a(KandianUrlImageView... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    while (j < k)
    {
      KandianUrlImageView localKandianUrlImageView = paramVarArgs[j];
      if (localKandianUrlImageView != null)
      {
        a(localKandianUrlImageView);
        ((LinearLayout.LayoutParams)localKandianUrlImageView.getLayoutParams()).setMargins(0, 0, AIOUtils.b(this.jdField_a_of_type_Float, getResources()), 0);
      }
      j += 1;
    }
  }
  
  public void b(KandianUrlImageView... paramVarArgs)
  {
    int k = paramVarArgs.length;
    int j = 0;
    while (j < k)
    {
      a(paramVarArgs[j]);
      j += 1;
    }
  }
  
  public void setAdapter(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public void setContent(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject2 = paramIReadInJoyModel.a();
    if (localObject2 == null) {
      return;
    }
    Object localObject3 = ((AbsBaseArticleInfo)localObject2).innerUniqueID;
    Object localObject6 = new LinearLayout.LayoutParams(-2, -2);
    Object localObject4 = JSONUtils.a(((AbsBaseArticleInfo)localObject2).mJsonPictureList, "pictures");
    if (localObject4 != null)
    {
      if (((JSONArray)localObject4).length() <= 0) {
        return;
      }
      int j = a((JSONArray)localObject4, ((AbsBaseArticleInfo)localObject2).articleStyle);
      Object localObject5 = new int[((JSONArray)localObject4).length()];
      boolean bool;
      if ((j != 5) && (j != 4)) {
        bool = false;
      } else {
        bool = true;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Float = 3.0F;
      }
      Object localObject1;
      if (j == 3)
      {
        paramIReadInJoyModel = new LinearLayout(getContext());
        paramIReadInJoyModel.setOrientation(0);
        paramIReadInJoyModel.setLayoutParams((ViewGroup.LayoutParams)localObject6);
        localObject1 = LayoutInflater.from(getContext()).inflate(2131560124, null);
        localObject3 = (TextView)((View)localObject1).findViewById(2131379809);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((AbsBaseArticleInfo)localObject2).mGalleryPicNumber);
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131702468));
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)((View)localObject1).findViewById(2131368461));
        UtilsForComponent.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView);
        paramIReadInJoyModel.addView((View)localObject1);
        ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, ((AbsBaseArticleInfo)localObject2).mSinglePicture, getContext());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIReadInJoyModel);
        return;
      }
      if (j == 4)
      {
        localObject3 = new LinearLayout(getContext());
        ((LinearLayout)localObject3).setOrientation(0);
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
        paramIReadInJoyModel = LayoutInflater.from(getContext()).inflate(2131560124, null);
        localObject1 = (TextView)paramIReadInJoyModel.findViewById(2131379809);
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(((AbsBaseArticleInfo)localObject2).mGalleryPicNumber);
        ((StringBuilder)localObject5).append(HardCodeUtil.a(2131702489));
        ((TextView)localObject1).setText(((StringBuilder)localObject5).toString());
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = new KandianUrlImageView(getContext());
        this.b = new KandianUrlImageView(getContext());
        this.c = ((KandianUrlImageView)paramIReadInJoyModel.findViewById(2131368461));
        ((LinearLayout)localObject3).addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView);
        ((LinearLayout)localObject3).addView(this.b);
        ((LinearLayout)localObject3).addView(paramIReadInJoyModel);
        a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.b });
        b(new KandianUrlImageView[] { this.c });
        this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.b, this.c });
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
        }
        else
        {
          paramIReadInJoyModel = ((JSONArray)localObject4).optJSONObject(0);
          if (paramIReadInJoyModel == null) {
            paramIReadInJoyModel = ((AbsBaseArticleInfo)localObject2).mFirstPagePicUrl;
          } else {
            paramIReadInJoyModel = paramIReadInJoyModel.optString("picture");
          }
          localObject1 = ((JSONArray)localObject4).optJSONObject(1);
          if (localObject1 == null) {
            localObject1 = ((AbsBaseArticleInfo)localObject2).mFirstPagePicUrl;
          } else {
            localObject1 = ((JSONObject)localObject1).optString("picture");
          }
          localObject4 = ((JSONArray)localObject4).optJSONObject(2);
          if (localObject4 == null) {
            localObject2 = ((AbsBaseArticleInfo)localObject2).mFirstPagePicUrl;
          } else {
            localObject2 = ((JSONObject)localObject4).optString("picture");
          }
          RIJComponentConfigImage.a(this.jdField_a_of_type_JavaUtilList, Arrays.asList(new URL[] { RIJConvertString2URL.a(paramIReadInJoyModel), RIJConvertString2URL.a((String)localObject1), RIJConvertString2URL.a((String)localObject2) }), getContext());
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        return;
      }
      if (j == 5)
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject7 = a();
        j = 0;
        while (j < 9)
        {
          localObject1 = ((JSONArray)localObject4).optJSONObject(j);
          if (localObject1 == null) {
            paramIReadInJoyModel = ((AbsBaseArticleInfo)localObject2).mFirstPagePicUrl;
          } else {
            paramIReadInJoyModel = ((JSONObject)localObject1).optString("picture");
          }
          int k;
          if (localObject1 == null) {
            k = 0;
          } else {
            k = ((JSONObject)localObject1).optInt("galleryIndex");
          }
          localObject5[j] = k;
          localObject1 = paramIReadInJoyModel;
          if (RIJPreParseData.a(paramIReadInJoyModel)) {
            localObject1 = RIJPreParseData.a(paramIReadInJoyModel, ((Integer)((Pair)localObject7).second).intValue(), ((Integer)((Pair)localObject7).first).intValue(), 1);
          }
          localArrayList.add(RIJConvertString2URL.a((String)localObject1));
          j += 1;
        }
        paramIReadInJoyModel = new LinearLayout(getContext());
        localObject1 = new LinearLayout(getContext());
        localObject4 = new LinearLayout(getContext());
        ((LinearLayout.LayoutParams)localObject6).setMargins(DisplayUtil.a(getContext(), 11.0F), 0, DisplayUtil.a(getContext(), 11.0F), 0);
        paramIReadInJoyModel.setOrientation(0);
        paramIReadInJoyModel.setLayoutParams((ViewGroup.LayoutParams)localObject6);
        ((LinearLayout)localObject1).setOrientation(0);
        ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject6);
        ((LinearLayout)localObject4).setOrientation(0);
        ((LinearLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject6);
        ((LinearLayout)localObject1).setPadding(0, AIOUtils.b(this.jdField_a_of_type_Float, getResources()), 0, 0);
        ((LinearLayout)localObject4).setPadding(0, AIOUtils.b(this.jdField_a_of_type_Float, getResources()), 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = new KandianUrlImageView(getContext());
        this.b = new KandianUrlImageView(getContext());
        this.c = new KandianUrlImageView(getContext());
        paramIReadInJoyModel.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView);
        paramIReadInJoyModel.addView(this.b);
        paramIReadInJoyModel.addView(this.c);
        this.d = new KandianUrlImageView(getContext());
        this.e = new KandianUrlImageView(getContext());
        this.f = new KandianUrlImageView(getContext());
        ((LinearLayout)localObject1).addView(this.d);
        ((LinearLayout)localObject1).addView(this.e);
        ((LinearLayout)localObject1).addView(this.f);
        localObject6 = LayoutInflater.from(getContext()).inflate(2131560124, null);
        localObject7 = (TextView)((View)localObject6).findViewById(2131379809);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((AbsBaseArticleInfo)localObject2).mGalleryPicNumber);
        localStringBuilder.append(HardCodeUtil.a(2131702514));
        ((TextView)localObject7).setText(localStringBuilder.toString());
        this.g = new KandianUrlImageView(getContext());
        this.h = new KandianUrlImageView(getContext());
        this.i = ((KandianUrlImageView)((View)localObject6).findViewById(2131368461));
        ((LinearLayout)localObject4).addView(this.g);
        ((LinearLayout)localObject4).addView(this.h);
        ((LinearLayout)localObject4).addView((View)localObject6);
        a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.b, this.d, this.e, this.g, this.h });
        b(new KandianUrlImageView[] { this.c, this.f, this.i });
        this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i });
        RIJComponentConfigImage.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
        a(this.jdField_a_of_type_JavaUtilList, (AbsBaseArticleInfo)localObject2, (int[])localObject5, (String)localObject3);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIReadInJoyModel);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
      }
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGallery
 * JD-Core Version:    0.7.0.1
 */