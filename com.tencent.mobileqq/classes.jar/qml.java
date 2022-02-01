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
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class qml
  extends qjh
{
  TextView a;
  TextView b;
  
  public qml(Context paramContext, aoof paramaoof, sel paramsel)
  {
    super(paramContext, paramaoof, paramsel);
  }
  
  public qjh a()
  {
    return l().t().n();
  }
  
  public qjh d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    localLinearLayout.setOnClickListener(new qmm(this));
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 2))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560186, localLinearLayout, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localRelativeLayout.findViewById(2131378936));
      this.b = ((TextView)localRelativeLayout.findViewById(2131371384));
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 2);
        this.b.setMaxWidth(((DisplayMetrics)localObject).widthPixels / 4);
      }
      localObject = (LinearLayout)localRelativeLayout.findViewById(2131365048);
      int i = 0;
      while (i < 2)
      {
        ComponentTopicItemMulti localComponentTopicItemMulti = (ComponentTopicItemMulti)this.jdField_a_of_type_JavaUtilList.get(i);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        if (i < 1) {
          localLayoutParams.rightMargin = agej.a(0.75F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
        if (i > 0) {
          localLayoutParams.leftMargin = agej.a(0.75F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  public qjh e()
  {
    return null;
  }
  
  public qjh o()
  {
    super.o();
    ArticleInfo localArticleInfo;
    qzb localqzb;
    if ((this.jdField_a_of_type_JavaLangObject instanceof ppu))
    {
      localArticleInfo = ((ppu)this.jdField_a_of_type_JavaLangObject).a();
      localqzb = localArticleInfo.mTopicRecommendFeedsInfo;
      if ((localqzb != null) && (localqzb.jdField_a_of_type_JavaUtilArrayList != null) && (localqzb.jdField_a_of_type_JavaUtilArrayList.size() >= 2)) {
        break label57;
      }
    }
    label271:
    label281:
    for (;;)
    {
      return this;
      label57:
      if (localqzb.jdField_a_of_type_Qzc != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localqzb.jdField_a_of_type_Qzc.a);
        label78:
        if ((localqzb.b == null) || (TextUtils.isEmpty(localqzb.b.a))) {
          break label271;
        }
        this.b.setVisibility(0);
        this.b.setText(localqzb.b.a);
        if (!TextUtils.isEmpty(localqzb.b.b)) {
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
          ((ComponentTopicItemMulti)this.jdField_a_of_type_JavaUtilList.get(i)).a(localqzb.jdField_a_of_type_JavaUtilArrayList.get(i));
          ((ComponentTopicItemMulti)this.jdField_a_of_type_JavaUtilList.get(i)).setArticleInfo(localArticleInfo, ((ppu)this.jdField_a_of_type_JavaLangObject).e());
          i += 1;
        }
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
        break label78;
        label251:
        this.b.setOnClickListener(new qmn(this, localArticleInfo, localqzb));
        continue;
        this.b.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qml
 * JD-Core Version:    0.7.0.1
 */