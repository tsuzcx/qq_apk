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
  private int o;
  private boolean p = false;
  private float q = 1.5F;
  
  public ComponentContentGallery(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentContentGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
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
  
  private void a(List<KandianUrlImageView> paramList, AbsBaseArticleInfo paramAbsBaseArticleInfo, int[] paramArrayOfInt, String paramString)
  {
    if ((paramList != null) && (paramArrayOfInt != null))
    {
      if (paramList.size() != paramArrayOfInt.length) {
        return;
      }
      int i1 = 0;
      while (i1 < paramList.size())
      {
        ((KandianUrlImageView)paramList.get(i1)).setOnClickListener(new ComponentContentGallery.1(this, paramAbsBaseArticleInfo, paramArrayOfInt[i1], paramString, i1));
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
    int i1 = localResources.getDisplayMetrics().widthPixels;
    int i2;
    if (this.p)
    {
      i1 = (i1 - AIOUtils.b(this.q * 2.0F, localResources) - AIOUtils.b(22.0F, localResources)) / 3;
      i2 = i1;
    }
    else
    {
      i1 = (i1 - AIOUtils.b(this.q * 2.0F, localResources)) / 3;
      i2 = localResources.getDimensionPixelSize(2131299547);
    }
    return new Pair(Integer.valueOf(i1), Integer.valueOf(i2));
  }
  
  public int a(JSONArray paramJSONArray, int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 5)
    {
      i1 = paramInt;
      if (paramJSONArray.length() < 9) {
        i1 = 4;
      }
    }
    paramInt = i1;
    if (i1 == 4)
    {
      paramInt = i1;
      if (paramJSONArray.length() < 3) {
        paramInt = 3;
      }
    }
    return paramInt;
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
        ((LinearLayout.LayoutParams)localKandianUrlImageView.getLayoutParams()).setMargins(0, 0, AIOUtils.b(this.q, getResources()), 0);
      }
      i1 += 1;
    }
  }
  
  public View b(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
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
    Object localObject2 = paramIReadInJoyModel.k();
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
      int i1 = a((JSONArray)localObject4, ((AbsBaseArticleInfo)localObject2).articleStyle);
      Object localObject5 = new int[((JSONArray)localObject4).length()];
      boolean bool;
      if ((i1 != 5) && (i1 != 4)) {
        bool = false;
      } else {
        bool = true;
      }
      this.p = bool;
      if (this.p) {
        this.q = 3.0F;
      }
      Object localObject1;
      if (i1 == 3)
      {
        paramIReadInJoyModel = new LinearLayout(getContext());
        paramIReadInJoyModel.setOrientation(0);
        paramIReadInJoyModel.setLayoutParams((ViewGroup.LayoutParams)localObject6);
        localObject1 = LayoutInflater.from(getContext()).inflate(2131626171, null);
        localObject3 = (TextView)((View)localObject1).findViewById(2131448641);
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((AbsBaseArticleInfo)localObject2).mGalleryPicNumber);
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131900470));
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
        this.d = ((KandianUrlImageView)((View)localObject1).findViewById(2131435357));
        UtilsForComponent.a(getContext(), this.d);
        paramIReadInJoyModel.addView((View)localObject1);
        ReadInJoyDisplayUtils.a(this.d, ((AbsBaseArticleInfo)localObject2).mSinglePicture, getContext());
        this.c.addView(paramIReadInJoyModel);
        return;
      }
      if (i1 == 4)
      {
        localObject3 = new LinearLayout(getContext());
        ((LinearLayout)localObject3).setOrientation(0);
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject6);
        paramIReadInJoyModel = LayoutInflater.from(getContext()).inflate(2131626171, null);
        localObject1 = (TextView)paramIReadInJoyModel.findViewById(2131448641);
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(((AbsBaseArticleInfo)localObject2).mGalleryPicNumber);
        ((StringBuilder)localObject5).append(HardCodeUtil.a(2131900488));
        ((TextView)localObject1).setText(((StringBuilder)localObject5).toString());
        this.d = new KandianUrlImageView(getContext());
        this.e = new KandianUrlImageView(getContext());
        this.f = ((KandianUrlImageView)paramIReadInJoyModel.findViewById(2131435357));
        ((LinearLayout)localObject3).addView(this.d);
        ((LinearLayout)localObject3).addView(this.e);
        ((LinearLayout)localObject3).addView(paramIReadInJoyModel);
        a(new KandianUrlImageView[] { this.d, this.e });
        b(new KandianUrlImageView[] { this.f });
        this.m = Arrays.asList(new KandianUrlImageView[] { this.d, this.e, this.f });
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
          RIJComponentConfigImage.a(this.m, Arrays.asList(new URL[] { paramIReadInJoyModel, localObject1, localObject2 }), getContext());
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
          RIJComponentConfigImage.a(this.m, Arrays.asList(new URL[] { RIJConvertString2URL.b(paramIReadInJoyModel), RIJConvertString2URL.b((String)localObject1), RIJConvertString2URL.b((String)localObject2) }), getContext());
        }
        this.c.addView((View)localObject3);
        return;
      }
      if (i1 == 5)
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject7 = getReadinjoyFeedsSmallPictureSize();
        i1 = 0;
        while (i1 < 9)
        {
          localObject1 = ((JSONArray)localObject4).optJSONObject(i1);
          if (localObject1 == null) {
            paramIReadInJoyModel = ((AbsBaseArticleInfo)localObject2).mFirstPagePicUrl;
          } else {
            paramIReadInJoyModel = ((JSONObject)localObject1).optString("picture");
          }
          int i2;
          if (localObject1 == null) {
            i2 = 0;
          } else {
            i2 = ((JSONObject)localObject1).optInt("galleryIndex");
          }
          localObject5[i1] = i2;
          localObject1 = paramIReadInJoyModel;
          if (RIJPreParseData.a(paramIReadInJoyModel)) {
            localObject1 = RIJPreParseData.a(paramIReadInJoyModel, ((Integer)((Pair)localObject7).second).intValue(), ((Integer)((Pair)localObject7).first).intValue(), 1);
          }
          localArrayList.add(RIJConvertString2URL.b((String)localObject1));
          i1 += 1;
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
        ((LinearLayout)localObject1).setPadding(0, AIOUtils.b(this.q, getResources()), 0, 0);
        ((LinearLayout)localObject4).setPadding(0, AIOUtils.b(this.q, getResources()), 0, 0);
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
        localObject6 = LayoutInflater.from(getContext()).inflate(2131626171, null);
        localObject7 = (TextView)((View)localObject6).findViewById(2131448641);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((AbsBaseArticleInfo)localObject2).mGalleryPicNumber);
        localStringBuilder.append(HardCodeUtil.a(2131900510));
        ((TextView)localObject7).setText(localStringBuilder.toString());
        this.j = new KandianUrlImageView(getContext());
        this.k = new KandianUrlImageView(getContext());
        this.l = ((KandianUrlImageView)((View)localObject6).findViewById(2131435357));
        ((LinearLayout)localObject4).addView(this.j);
        ((LinearLayout)localObject4).addView(this.k);
        ((LinearLayout)localObject4).addView((View)localObject6);
        a(new KandianUrlImageView[] { this.d, this.e, this.g, this.h, this.j, this.k });
        b(new KandianUrlImageView[] { this.f, this.i, this.l });
        this.m = Arrays.asList(new KandianUrlImageView[] { this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l });
        RIJComponentConfigImage.a(this.m, localArrayList, getContext());
        a(this.m, (AbsBaseArticleInfo)localObject2, (int[])localObject5, (String)localObject3);
        this.c.addView(paramIReadInJoyModel);
        this.c.addView((View)localObject1);
        this.c.addView((View)localObject4);
      }
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.o = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGallery
 * JD-Core Version:    0.7.0.1
 */