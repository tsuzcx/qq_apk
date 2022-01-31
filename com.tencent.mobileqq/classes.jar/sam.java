import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.widget.HorizontalLabelLayout;
import java.util.List;

class sam
  extends sah
  implements View.OnClickListener
{
  private HorizontalLabelLayout jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout;
  
  public sam(sal paramsal, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout = ((HorizontalLabelLayout)paramView);
  }
  
  private View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560012, (ViewGroup)this.jdField_a_of_type_AndroidViewView, false);
  }
  
  private void a(String paramString, rzy paramrzy, ArticleInfo paramArticleInfo)
  {
    long l1 = paramArticleInfo.mArticleID;
    long l2 = paramrzy.jdField_a_of_type_Long;
    nrt.a(null, "CliOper", "", ors.a(), paramString, paramString, 0, 0, String.valueOf(l1), String.valueOf(l2), paramArticleInfo.innerUniqueID, "", false);
  }
  
  public SpannableStringBuilder a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("# ");
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#07D0B0")), 0, localSpannableStringBuilder.length(), 33);
    double d = 0.0D;
    int i = 0;
    for (;;)
    {
      if (i < paramString.length()) {
        if (!bdnn.c(paramString.charAt(i))) {
          break label144;
        }
      }
      label144:
      for (d += 1.0D; d >= 11.0D; d += 0.5D)
      {
        String str = paramString;
        if (i < paramString.length() - 1) {
          str = paramString.substring(0, i + 1) + oqu.jdField_a_of_type_JavaLangString;
        }
        localSpannableStringBuilder.append(str);
        return localSpannableStringBuilder;
      }
      i += 1;
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    paramBaseData1 = (ArticleTopicData)paramBaseData2;
    int j = paramBaseData1.jdField_a_of_type_JavaUtilList.size();
    View localView;
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getChildCount() < j)
    {
      int k = this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getChildCount();
      i = 0;
      while (i < j - k)
      {
        localView = a(this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getContext());
        this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.addView(localView);
        localView.setOnClickListener(this);
        i += 1;
      }
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getChildCount())
    {
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalLabelLayout.getChildAt(i);
      if (i < j)
      {
        localView.setVisibility(0);
        rzy localrzy = (rzy)paramBaseData1.jdField_a_of_type_JavaUtilList.get(i);
        localView.setTag(localrzy);
        ((TextView)localView.findViewById(2131375273)).setText(a(localrzy.jdField_a_of_type_JavaLangString));
        if ((!paramBoolean) && (!paramBaseData1.jdField_a_of_type_Boolean))
        {
          a("0X800919F", localrzy, paramBaseData2.b);
          paramBaseData1.jdField_a_of_type_Boolean = true;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localView.setVisibility(8);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    rzy localrzy = (rzy)paramView.getTag();
    if (localrzy != null)
    {
      ors.a(paramView.getContext(), localrzy.b);
      a("0X80091A0", localrzy, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sam
 * JD-Core Version:    0.7.0.1
 */