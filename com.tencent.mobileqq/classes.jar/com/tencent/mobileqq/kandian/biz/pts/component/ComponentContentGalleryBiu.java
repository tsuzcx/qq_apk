package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
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
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.GalleryPGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComponentContentGalleryBiu
  extends FrameLayout
  implements ComponentInheritView
{
  private float jdField_a_of_type_Float = 3.0F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  private List<KandianUrlImageView> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private KandianUrlImageView jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private boolean jdField_b_of_type_Boolean = false;
  private KandianUrlImageView c;
  private KandianUrlImageView d;
  private KandianUrlImageView e;
  private KandianUrlImageView f;
  private KandianUrlImageView g;
  private KandianUrlImageView h;
  private KandianUrlImageView i;
  
  public ComponentContentGalleryBiu(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentGalleryBiu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = paramInt2;
    if (paramInt2 == 9) {
      if (paramInt1 < 9) {
        j = 3;
      } else {
        return 9;
      }
    }
    if ((j == 3) && (paramInt1 >= 3)) {
      return 3;
    }
    return 1;
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    return GalleryReportedUtils.a(paramReadInJoyBaseAdapter.a(), RIJFeedsType.a(paramAbsBaseArticleInfo));
  }
  
  private Pair<Integer, Integer> a()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int k = (localResources.getDisplayMetrics().widthPixels - AIOUtils.b(this.jdField_a_of_type_Float * 2.0F, localResources) - AIOUtils.b(22.0F, localResources)) / 3;
    int j = localResources.getDimensionPixelSize(2131298830);
    if (this.jdField_a_of_type_Boolean) {
      j = k;
    }
    return new Pair(Integer.valueOf(k), Integer.valueOf(j));
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
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localObject != null)
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      localObject = ((ReadInJoyBaseAdapter)localObject).a().a();
      if (localObject != null) {
        ((OnGalleryImageClickListener)localObject).a(getContext(), paramAbsBaseArticleInfo, 0, paramAbsBaseArticleInfo.innerUniqueID, 5, this.jdField_a_of_type_Int, 0);
      }
    }
  }
  
  private void a(List<KandianUrlImageView> paramList, AbsBaseArticleInfo paramAbsBaseArticleInfo, long[] paramArrayOfLong, String paramString)
  {
    if ((paramList != null) && (paramArrayOfLong != null))
    {
      if (paramList.size() != paramArrayOfLong.length) {
        return;
      }
      int j = 0;
      while (j < paramList.size())
      {
        ((KandianUrlImageView)paramList.get(j)).setOnClickListener(new ComponentContentGalleryBiu.2(this, paramAbsBaseArticleInfo, paramArrayOfLong[j], paramString, j));
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
  
  public View a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
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
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null))
    {
      if (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityGalleryPGCFeedsInfo == null) {
        return;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        paramIReadInJoyModel = new TextView(getContext());
        paramIReadInJoyModel.setPadding(0, 0, 0, AIOUtils.b(11.0F, getContext().getResources()));
        paramIReadInJoyModel.setMaxLines(2);
        paramIReadInJoyModel.setEllipsize(TextUtils.TruncateAt.END);
        paramIReadInJoyModel.setTextColor(Color.parseColor("#000000"));
        paramIReadInJoyModel.setTextSize(1, 17.0F);
        paramIReadInJoyModel.setIncludeFontPadding(false);
        paramIReadInJoyModel.setText(localAbsBaseArticleInfo.mTitle);
        paramIReadInJoyModel.setOnClickListener(new ComponentContentGalleryBiu.1(this, localAbsBaseArticleInfo));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIReadInJoyModel);
      }
      String str = localAbsBaseArticleInfo.innerUniqueID;
      paramIReadInJoyModel = localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo;
      Object localObject4 = localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityGalleryPGCFeedsInfo;
      paramIReadInJoyModel = paramIReadInJoyModel.jdField_a_of_type_JavaUtilArrayList;
      if (paramIReadInJoyModel != null)
      {
        if (paramIReadInJoyModel.size() == 0) {
          return;
        }
        int j = paramIReadInJoyModel.size();
        if (j <= 0) {
          return;
        }
        int k = a(j, localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
        long[] arrayOfLong = new long[k];
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        if ((k != 9) && (k != 3)) {
          bool = false;
        } else {
          bool = true;
        }
        this.jdField_a_of_type_Boolean = bool;
        Object localObject5 = a();
        j = 0;
        Object localObject1;
        Object localObject2;
        while (j < k)
        {
          localObject1 = (PGCPicInfo)paramIReadInJoyModel.get(j);
          arrayOfLong[j] = ((PGCPicInfo)localObject1).a;
          localObject2 = ((PGCPicInfo)localObject1).b;
          localObject1 = localObject2;
          if (RIJPreParseData.a((String)localObject2)) {
            localObject1 = RIJPreParseData.a((String)localObject2, ((Integer)((Pair)localObject5).second).intValue(), ((Integer)((Pair)localObject5).first).intValue(), 1);
          }
          localArrayList.add(RIJConvertString2URL.a((String)localObject1));
          j += 1;
        }
        long l = ((GalleryPGCFeedsInfo)localObject4).a;
        if ((k != 1) && (k != 3))
        {
          if (k == 9)
          {
            paramIReadInJoyModel = new LinearLayout(getContext());
            localObject1 = new LinearLayout(getContext());
            localObject2 = new LinearLayout(getContext());
            paramIReadInJoyModel.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            ((LinearLayout)localObject1).setPadding(0, AIOUtils.b(this.jdField_a_of_type_Float, getResources()), 0, 0);
            ((LinearLayout)localObject2).setPadding(0, AIOUtils.b(this.jdField_a_of_type_Float, getResources()), 0, 0);
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = new KandianUrlImageView(getContext());
            this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = new KandianUrlImageView(getContext());
            this.c = new KandianUrlImageView(getContext());
            paramIReadInJoyModel.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView);
            paramIReadInJoyModel.addView(this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView);
            paramIReadInJoyModel.addView(this.c);
            this.d = new KandianUrlImageView(getContext());
            this.e = new KandianUrlImageView(getContext());
            this.f = new KandianUrlImageView(getContext());
            ((LinearLayout)localObject1).addView(this.d);
            ((LinearLayout)localObject1).addView(this.e);
            ((LinearLayout)localObject1).addView(this.f);
            localObject3 = LayoutInflater.from(getContext()).inflate(2131560124, null);
            localObject4 = (TextView)((View)localObject3).findViewById(2131379809);
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(l);
            ((StringBuilder)localObject5).append(HardCodeUtil.a(2131702438));
            ((TextView)localObject4).setText(((StringBuilder)localObject5).toString());
            this.g = new KandianUrlImageView(getContext());
            this.h = new KandianUrlImageView(getContext());
            this.i = ((KandianUrlImageView)((View)localObject3).findViewById(2131368461));
            ((LinearLayout)localObject2).addView(this.g);
            ((LinearLayout)localObject2).addView(this.h);
            ((LinearLayout)localObject2).addView((View)localObject3);
            a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.d, this.e, this.g, this.h });
            b(new KandianUrlImageView[] { this.c, this.f, this.i });
            this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.c, this.d, this.e, this.f, this.g, this.h, this.i });
            RIJComponentConfigImage.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIReadInJoyModel);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
          }
        }
        else
        {
          paramIReadInJoyModel = new LinearLayout(getContext());
          paramIReadInJoyModel.setOrientation(0);
          paramIReadInJoyModel.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject1 = LayoutInflater.from(getContext()).inflate(2131560124, null);
          localObject2 = (TextView)((View)localObject1).findViewById(2131379809);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(l);
          ((StringBuilder)localObject3).append(HardCodeUtil.a(2131702512));
          ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
          if (k == 1)
          {
            paramIReadInJoyModel.addView((View)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)((View)localObject1).findViewById(2131368461));
            this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView });
            UtilsForComponent.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView);
            ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, localAbsBaseArticleInfo.mSinglePicture, getContext());
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIReadInJoyModel);
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = new KandianUrlImageView(getContext());
            this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = new KandianUrlImageView(getContext());
            this.c = ((KandianUrlImageView)((View)localObject1).findViewById(2131368461));
            paramIReadInJoyModel.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView);
            paramIReadInJoyModel.addView(this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView);
            paramIReadInJoyModel.addView((View)localObject1);
            a(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView });
            b(new KandianUrlImageView[] { this.c });
            this.jdField_a_of_type_JavaUtilList = Arrays.asList(new KandianUrlImageView[] { this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.c });
            RIJComponentConfigImage.a(this.jdField_a_of_type_JavaUtilList, localArrayList, getContext());
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramIReadInJoyModel);
          }
        }
        a(this.jdField_a_of_type_JavaUtilList, localAbsBaseArticleInfo, arrayOfLong, str);
      }
    }
  }
  
  public void setIsNeedAddTitle(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGalleryBiu
 * JD-Core Version:    0.7.0.1
 */