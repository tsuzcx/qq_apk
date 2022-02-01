import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class ret
  extends rbp
{
  TextView a;
  TextView b;
  
  public ret(Context paramContext, FaceDecoder paramFaceDecoder, szd paramszd)
  {
    super(paramContext, paramFaceDecoder, paramszd);
  }
  
  public rbp a()
  {
    return l().t().n();
  }
  
  public rbp d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOnClickListener(new reu(this));
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 2))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560239, localLinearLayout, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localRelativeLayout.findViewById(2131379001));
      this.b = ((TextView)localRelativeLayout.findViewById(2131371538));
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 2);
        this.b.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 4);
      }
      localObject = (LinearLayout)localRelativeLayout.findViewById(2131365159);
      int i = 0;
      while (i < 2)
      {
        ComponentTopicItemMulti localComponentTopicItemMulti = (ComponentTopicItemMulti)this.jdField_a_of_type_JavaUtilList.get(i);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        if (i < 1) {
          localLayoutParams.rightMargin = AIOUtils.dp2px(0.75F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
        if (i > 0) {
          localLayoutParams.leftMargin = AIOUtils.dp2px(0.75F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
        localComponentTopicItemMulti.setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject).addView(localComponentTopicItemMulti);
        i += 1;
      }
      localLinearLayout.addView(localRelativeLayout);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localLinearLayout);
    return this;
  }
  
  public rbp e()
  {
    return null;
  }
  
  public rbp o()
  {
    super.o();
    ArticleInfo localArticleInfo;
    rsh localrsh;
    if ((this.jdField_a_of_type_JavaLangObject instanceof qfw))
    {
      localArticleInfo = ((qfw)this.jdField_a_of_type_JavaLangObject).a();
      localrsh = localArticleInfo.mTopicRecommendFeedsInfo;
      if ((localrsh != null) && (localrsh.jdField_a_of_type_JavaUtilArrayList != null) && (localrsh.jdField_a_of_type_JavaUtilArrayList.size() >= 2)) {
        break label57;
      }
    }
    label271:
    label281:
    for (;;)
    {
      return this;
      label57:
      if (localrsh.jdField_a_of_type_Rsi != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localrsh.jdField_a_of_type_Rsi.a);
        label78:
        if ((localrsh.b == null) || (TextUtils.isEmpty(localrsh.b.a))) {
          break label271;
        }
        this.b.setVisibility(0);
        this.b.setText(localrsh.b.a);
        if (!TextUtils.isEmpty(localrsh.b.b)) {
          break label251;
        }
        this.b.setCompoundDrawables(null, null, null, null);
        this.b.setOnClickListener(null);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 2)) {
          break label281;
        }
        int i = 0;
        while (i < 2)
        {
          ((ComponentTopicItemMulti)this.jdField_a_of_type_JavaUtilList.get(i)).a(localrsh.jdField_a_of_type_JavaUtilArrayList.get(i));
          ((ComponentTopicItemMulti)this.jdField_a_of_type_JavaUtilList.get(i)).setArticleInfo(localArticleInfo, ((qfw)this.jdField_a_of_type_JavaLangObject).e());
          i += 1;
        }
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        break label78;
        label251:
        this.b.setOnClickListener(new rev(this, localArticleInfo, localrsh));
        continue;
        this.b.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ret
 * JD-Core Version:    0.7.0.1
 */