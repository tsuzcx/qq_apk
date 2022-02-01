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
  private Context a;
  private CmpCtxt b;
  private LinearLayout c;
  private KandianUrlImageView d;
  private KandianUrlImageView e;
  private KandianUrlImageView f;
  private KandianUrlImageView g;
  private KandianUrlImageView h;
  private KandianUrlImageView i;
  private KandianUrlImageView j;
  private KandianUrlImageView k;
  private KandianUrlImageView l;
  private List<KandianUrlImageView> m;
  private ReadInJoyBaseAdapter n;
  private boolean o = false;
  private float p = 3.0F;
  private int q;
  private boolean r = false;
  
  public ComponentContentGalleryBiu(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentContentGalleryBiu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (paramInt2 == 9) {
      if (paramInt1 < 9) {
        i1 = 3;
      } else {
        return 9;
      }
    }
    if ((i1 == 3) && (paramInt1 >= 3)) {
      return 3;
    }
    return 1;
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    return GalleryReportedUtils.a(paramReadInJoyBaseAdapter.c(), RIJFeedsType.g(paramAbsBaseArticleInfo));
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView)
  {
    Object localObject = getReadinjoyFeedsSmallPictureSize();
    int i1 = ((Integer)((Pair)localObject).first).intValue();
    int i2 = ((Integer)((Pair)localObject).second).intValue();
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new LinearLayout.LayoutParams(i1, i2);
    }
    ((ViewGroup.LayoutParams)localObject).width = i1;
    ((ViewGroup.LayoutParams)localObject).height = i2;
    paramKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      localObject = ((ReadInJoyBaseAdapter)localObject).y().d();
      if (localObject != null) {
        ((OnGalleryImageClickListener)localObject).a(getContext(), paramAbsBaseArticleInfo, 0, paramAbsBaseArticleInfo.innerUniqueID, 5, this.q, 0);
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
      int i1 = 0;
      while (i1 < paramList.size())
      {
        ((KandianUrlImageView)paramList.get(i1)).setOnClickListener(new ComponentContentGalleryBiu.2(this, paramAbsBaseArticleInfo, paramArrayOfLong[i1], paramString, i1));
        i1 += 1;
      }
    }
  }
  
  private void c(Context paramContext)
  {
    this.b = new CmpCtxt();
    this.a = paramContext;
    a(paramContext);
    a();
  }
  
  private Pair<Integer, Integer> getReadinjoyFeedsSmallPictureSize()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i2 = (localResources.getDisplayMetrics().widthPixels - AIOUtils.b(this.p * 2.0F, localResources) - AIOUtils.b(22.0F, localResources)) / 3;
    int i1 = localResources.getDimensionPixelSize(2131299547);
    if (this.o) {
      i1 = i2;
    }
    return new Pair(Integer.valueOf(i2), Integer.valueOf(i1));
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(b(paramContext));
  }
  
  public void a(View paramView)
  {
    this.c = ((LinearLayout)paramView);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.b.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.b.a(paramObject);
      setContent(paramObject);
    }
  }
  
  public void a(KandianUrlImageView... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      KandianUrlImageView localKandianUrlImageView = paramVarArgs[i1];
      if (localKandianUrlImageView != null)
      {
        a(localKandianUrlImageView);
        ((LinearLayout.LayoutParams)localKandianUrlImageView.getLayoutParams()).setMargins(0, 0, AIOUtils.b(this.p, getResources()), 0);
      }
      i1 += 1;
    }
  }
  
  public View b(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    addView(paramContext);
    return paramContext;
  }
  
  public void b(KandianUrlImageView... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a(paramVarArgs[i1]);
      i1 += 1;
    }
  }
  
  public void setAdapter(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.n = paramReadInJoyBaseAdapter;
  }
  
  public void setContent(IReadInJoyModel paramIReadInJoyModel)
  {
    this.c.removeAllViews();
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.t != null))
    {
      if (localAbsBaseArticleInfo.mSocialFeedInfo.t.h == null) {
        return;
      }
      if (this.r)
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
        this.c.addView(paramIReadInJoyModel);
      }
      String str = localAbsBaseArticleInfo.innerUniqueID;
      paramIReadInJoyModel = localAbsBaseArticleInfo.mSocialFeedInfo.t;
      Object localObject4 = localAbsBaseArticleInfo.mSocialFeedInfo.t.h;
      paramIReadInJoyModel = paramIReadInJoyModel.a;
      if (paramIReadInJoyModel != null)
      {
        if (paramIReadInJoyModel.size() == 0) {
          return;
        }
        int i1 = paramIReadInJoyModel.size();
        if (i1 <= 0) {
          return;
        }
        int i2 = a(i1, localAbsBaseArticleInfo.mSocialFeedInfo.b);
        long[] arrayOfLong = new long[i2];
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        if ((i2 != 9) && (i2 != 3)) {
          bool = false;
        } else {
          bool = true;
        }
        this.o = bool;
        Object localObject5 = getReadinjoyFeedsSmallPictureSize();
        i1 = 0;
        Object localObject1;
        Object localObject2;
        while (i1 < i2)
        {
          localObject1 = (PGCPicInfo)paramIReadInJoyModel.get(i1);
          arrayOfLong[i1] = ((PGCPicInfo)localObject1).h;
          localObject2 = ((PGCPicInfo)localObject1).d;
          localObject1 = localObject2;
          if (RIJPreParseData.a((String)localObject2)) {
            localObject1 = RIJPreParseData.a((String)localObject2, ((Integer)((Pair)localObject5).second).intValue(), ((Integer)((Pair)localObject5).first).intValue(), 1);
          }
          localArrayList.add(RIJConvertString2URL.b((String)localObject1));
          i1 += 1;
        }
        long l1 = ((GalleryPGCFeedsInfo)localObject4).a;
        if ((i2 != 1) && (i2 != 3))
        {
          if (i2 == 9)
          {
            paramIReadInJoyModel = new LinearLayout(getContext());
            localObject1 = new LinearLayout(getContext());
            localObject2 = new LinearLayout(getContext());
            paramIReadInJoyModel.setLayoutParams((ViewGroup.LayoutParams)localObject3);
            ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            ((LinearLayout)localObject1).setPadding(0, AIOUtils.b(this.p, getResources()), 0, 0);
            ((LinearLayout)localObject2).setPadding(0, AIOUtils.b(this.p, getResources()), 0, 0);
            this.d = new KandianUrlImageView(getContext());
            this.e = new KandianUrlImageView(getContext());
            this.f = new KandianUrlImageView(getContext());
            paramIReadInJoyModel.addView(this.d);
            paramIReadInJoyModel.addView(this.e);
            paramIReadInJoyModel.addView(this.f);
            this.g = new KandianUrlImageView(getContext());
            this.h = new KandianUrlImageView(getContext());
            this.i = new KandianUrlImageView(getContext());
            ((LinearLayout)localObject1).addView(this.g);
            ((LinearLayout)localObject1).addView(this.h);
            ((LinearLayout)localObject1).addView(this.i);
            localObject3 = LayoutInflater.from(getContext()).inflate(2131626171, null);
            localObject4 = (TextView)((View)localObject3).findViewById(2131448641);
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append(l1);
            ((StringBuilder)localObject5).append(HardCodeUtil.a(2131900441));
            ((TextView)localObject4).setText(((StringBuilder)localObject5).toString());
            this.j = new KandianUrlImageView(getContext());
            this.k = new KandianUrlImageView(getContext());
            this.l = ((KandianUrlImageView)((View)localObject3).findViewById(2131435357));
            ((LinearLayout)localObject2).addView(this.j);
            ((LinearLayout)localObject2).addView(this.k);
            ((LinearLayout)localObject2).addView((View)localObject3);
            a(new KandianUrlImageView[] { this.d, this.e, this.g, this.h, this.j, this.k });
            b(new KandianUrlImageView[] { this.f, this.i, this.l });
            this.m = Arrays.asList(new KandianUrlImageView[] { this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l });
            RIJComponentConfigImage.a(this.m, localArrayList, getContext());
            this.c.addView(paramIReadInJoyModel);
            this.c.addView((View)localObject1);
            this.c.addView((View)localObject2);
          }
        }
        else
        {
          paramIReadInJoyModel = new LinearLayout(getContext());
          paramIReadInJoyModel.setOrientation(0);
          paramIReadInJoyModel.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject1 = LayoutInflater.from(getContext()).inflate(2131626171, null);
          localObject2 = (TextView)((View)localObject1).findViewById(2131448641);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(l1);
          ((StringBuilder)localObject3).append(HardCodeUtil.a(2131900508));
          ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
          if (i2 == 1)
          {
            paramIReadInJoyModel.addView((View)localObject1);
            this.d = ((KandianUrlImageView)((View)localObject1).findViewById(2131435357));
            this.m = Arrays.asList(new KandianUrlImageView[] { this.d });
            UtilsForComponent.a(getContext(), this.d);
            ReadInJoyDisplayUtils.a(this.d, localAbsBaseArticleInfo.mSinglePicture, getContext());
            this.c.addView(paramIReadInJoyModel);
          }
          else
          {
            this.d = new KandianUrlImageView(getContext());
            this.e = new KandianUrlImageView(getContext());
            this.f = ((KandianUrlImageView)((View)localObject1).findViewById(2131435357));
            paramIReadInJoyModel.addView(this.d);
            paramIReadInJoyModel.addView(this.e);
            paramIReadInJoyModel.addView((View)localObject1);
            a(new KandianUrlImageView[] { this.d, this.e });
            b(new KandianUrlImageView[] { this.f });
            this.m = Arrays.asList(new KandianUrlImageView[] { this.d, this.e, this.f });
            RIJComponentConfigImage.a(this.m, localArrayList, getContext());
            this.c.addView(paramIReadInJoyModel);
          }
        }
        a(this.m, localAbsBaseArticleInfo, arrayOfLong, str);
      }
    }
  }
  
  public void setIsNeedAddTitle(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public void setPosition(int paramInt)
  {
    this.q = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGalleryBiu
 * JD-Core Version:    0.7.0.1
 */