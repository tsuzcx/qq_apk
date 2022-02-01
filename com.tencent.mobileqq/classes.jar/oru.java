import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.List;

public class oru
  extends ReportDialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private orw jdField_a_of_type_Orw;
  private orx jdField_a_of_type_Orx;
  private LinearLayout b;
  
  public oru(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755338);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131560190);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131370340));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370351));
    this.jdField_a_of_type_Orx = new orx(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Orx);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new orv(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370351));
    this.b = ((LinearLayout)findViewById(2131370357));
    this.b.setOnClickListener(this);
    uab.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, afur.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    uab.a(this.jdField_a_of_type_AndroidWidgetListView, afur.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, orw paramorw, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Orw = paramorw;
    this.jdField_a_of_type_Orx.notifyDataSetChanged();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        paramorw = (GiftServiceBean)paramList.get(i);
        if ((!TextUtils.isEmpty(paramorw.t)) && (paramorw.t.equals(paramString))) {
          this.jdField_a_of_type_Int = i;
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oru
 * JD-Core Version:    0.7.0.1
 */