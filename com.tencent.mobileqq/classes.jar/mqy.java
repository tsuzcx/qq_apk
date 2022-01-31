import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class mqy
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public mqy(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367103));
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
    return AIOUtils.a(paramInt1, paramContext.getResources());
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    int i = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1))
    {
      int j = paramURLDrawable.getCurrDrawable().getIntrinsicWidth();
      int k = paramURLDrawable.getCurrDrawable().getIntrinsicHeight();
      if ((j != 0) && (k != 0))
      {
        int m = a(this.jdField_a_of_type_AndroidViewView.getContext(), j, i, i);
        paramURLDrawable = new LinearLayout.LayoutParams(m, k * m / j);
        paramURLDrawable.leftMargin = i;
        paramURLDrawable.rightMargin = i;
        if (a(j))
        {
          paramURLDrawable.topMargin = 10;
          paramURLDrawable.bottomMargin = 10;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramURLDrawable);
      }
      QLog.d("Q.readinjoy.fast_web", 2, " refrshImageViewFromDrawable: " + j + " :: " + k);
      return;
    }
    paramURLDrawable = new LinearLayout.LayoutParams(a(this.jdField_a_of_type_AndroidViewView.getContext()) - i - i, AIOUtils.a(190.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources()));
    paramURLDrawable.leftMargin = i;
    paramURLDrawable.rightMargin = i;
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramURLDrawable);
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt < 100;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    int i = 0;
    switch (paramBaseData2.d)
    {
    default: 
      return;
    }
    paramBaseData2 = (ImageData)paramBaseData2;
    Object localObject = (ImageData)paramBaseData1;
    int j = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData1 = URLDrawable.URLDrawableOptions.obtain();
    int k;
    int m;
    if ((paramBaseData2.jdField_a_of_type_Int != 0) && (paramBaseData2.b != 0))
    {
      k = a(this.jdField_a_of_type_AndroidViewView.getContext(), paramBaseData2.jdField_a_of_type_Int, j, j);
      m = paramBaseData2.b * k / paramBaseData2.jdField_a_of_type_Int;
      if ((!((ImageData)localObject).jdField_a_of_type_JavaLangString.equals(paramBaseData2.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Boolean))
      {
        localObject = new LinearLayout.LayoutParams(k, m);
        ((LinearLayout.LayoutParams)localObject).leftMargin = j;
        ((LinearLayout.LayoutParams)localObject).rightMargin = j;
        if (a(paramBaseData2.jdField_a_of_type_Int))
        {
          ((LinearLayout.LayoutParams)localObject).topMargin = 10;
          ((LinearLayout.LayoutParams)localObject).bottomMargin = 10;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_Boolean = false;
        this.b = 0;
        this.jdField_a_of_type_Int = 0;
      }
      if ((this.jdField_a_of_type_Int > 0) && (paramBaseData2.b * paramBaseData2.jdField_a_of_type_Int > 2000000))
      {
        paramBaseData1.mRequestWidth = (k >> this.b);
        paramBaseData1.mRequestHeight = (m >> this.b);
      }
    }
    for (;;)
    {
      paramBaseData1.mLoadingDrawable = new ColorDrawable(-2565414);
      paramBaseData1.mPlayGifImage = true;
      paramBaseData1.mMemoryCacheKeySuffix = "fast_web";
      paramBaseData1 = URLDrawable.getDrawable(PubAccountHttpDownloader.a(paramBaseData2.jdField_a_of_type_JavaLangString, 4), paramBaseData1);
      if (i != 0) {
        a(paramBaseData1);
      }
      if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
        paramBaseData1.restartDownload();
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData1);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new mqz(this));
      return;
      paramBaseData1.mRequestWidth = k;
      paramBaseData1.mRequestHeight = m;
      continue;
      i = 1;
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemOnItemClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (paramView = "2";; paramView = "1")
    {
      paramView = ReadInJoyUtils.a(localContext, localArticleInfo, 0, paramView);
      ReportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8008996", paramView.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqy
 * JD-Core Version:    0.7.0.1
 */