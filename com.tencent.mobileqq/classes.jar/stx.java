import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class stx
  extends stg
  implements View.OnClickListener
{
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private boolean jdField_a_of_type_Boolean = true;
  private int e;
  private int f;
  
  public stx(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369042));
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private static int a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a(paramInt1)) {
      return a(paramContext) - paramInt2 - paramInt3;
    }
    return AIOUtils.dp2px(paramInt1, paramContext.getResources());
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    int i = AIOUtils.dp2px(this.d, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    int j = AIOUtils.dp2px(this.c, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1))
    {
      int k = paramURLDrawable.getCurrDrawable().getIntrinsicWidth();
      int m = paramURLDrawable.getCurrDrawable().getIntrinsicHeight();
      if ((k != 0) && (m != 0))
      {
        int n = a(this.jdField_a_of_type_AndroidViewView.getContext(), k, i, i);
        paramURLDrawable = new LinearLayout.LayoutParams(n, m * n / k);
        paramURLDrawable.leftMargin = i;
        paramURLDrawable.rightMargin = i;
        paramURLDrawable.topMargin = j;
        paramURLDrawable.bottomMargin = j;
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramURLDrawable);
      }
      QLog.d("Q.readinjoy.fast_web", 2, " refrshImageViewFromDrawable: " + k + " :: " + m);
      return;
    }
    paramURLDrawable = new LinearLayout.LayoutParams(a(this.jdField_a_of_type_AndroidViewView.getContext()) - i - i, AIOUtils.dp2px(190.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources()));
    paramURLDrawable.leftMargin = i;
    paramURLDrawable.rightMargin = i;
    paramURLDrawable.topMargin = j;
    paramURLDrawable.bottomMargin = j;
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramURLDrawable);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt < 100;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    int i = 0;
    switch (paramBaseData2.r)
    {
    default: 
      return;
    }
    paramBaseData2 = (ImageData)paramBaseData2;
    Object localObject = (ImageData)paramBaseData1;
    int j = AIOUtils.dp2px(this.d, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    int k = AIOUtils.dp2px(this.c, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData1 = URLDrawable.URLDrawableOptions.obtain();
    int m;
    int n;
    if ((paramBaseData2.jdField_a_of_type_Int != 0) && (paramBaseData2.b != 0))
    {
      m = a(this.jdField_a_of_type_AndroidViewView.getContext(), paramBaseData2.jdField_a_of_type_Int, j, j);
      n = paramBaseData2.b * m / paramBaseData2.jdField_a_of_type_Int;
      if ((!((ImageData)localObject).jdField_a_of_type_JavaLangString.equals(paramBaseData2.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Boolean))
      {
        localObject = new LinearLayout.LayoutParams(m, n);
        ((LinearLayout.LayoutParams)localObject).leftMargin = j;
        ((LinearLayout.LayoutParams)localObject).rightMargin = j;
        ((LinearLayout.LayoutParams)localObject).topMargin = k;
        ((LinearLayout.LayoutParams)localObject).bottomMargin = k;
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_Boolean = false;
        this.f = 0;
        this.e = 0;
      }
      if ((this.e > 0) && (paramBaseData2.b * paramBaseData2.jdField_a_of_type_Int > 2000000))
      {
        paramBaseData1.mRequestWidth = (m >> this.f);
        paramBaseData1.mRequestHeight = (n >> this.f);
      }
    }
    for (;;)
    {
      paramBaseData1.mLoadingDrawable = new ColorDrawable(-2565414);
      paramBaseData1.mPlayGifImage = true;
      paramBaseData1.mUseSharpPImage = bjkq.a(this.jdField_a_of_type_AndroidViewView.getContext());
      paramBaseData1.mMemoryCacheKeySuffix = "fast_web";
      paramBaseData1 = URLDrawable.getDrawable(uet.a(stw.a(paramBaseData2.jdField_a_of_type_JavaLangString, paramBaseData2), 4), paramBaseData1);
      if (i != 0) {
        a(paramBaseData1);
      }
      if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
        paramBaseData1.restartDownload();
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData1);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new sty(this));
      return;
      paramBaseData1.mRequestWidth = m;
      paramBaseData1.mRequestHeight = n;
      continue;
      i = 1;
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Stl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c()) {}
    for (Object localObject = "2";; localObject = "1")
    {
      localObject = pay.a(localContext, localArticleInfo, 0, (String)localObject);
      swy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X8008996", ((JSONObject)localObject).toString());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stx
 * JD-Core Version:    0.7.0.1
 */