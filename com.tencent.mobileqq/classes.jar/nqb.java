import android.app.Dialog;
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
import java.util.ArrayList;
import java.util.List;

public class nqb
  extends Dialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private nqd jdField_a_of_type_Nqd;
  private nqe jdField_a_of_type_Nqe;
  private LinearLayout b;
  
  public nqb(Context paramContext, int paramInt)
  {
    super(paramContext, 2131689789);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131494376);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131303940));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303954));
    this.jdField_a_of_type_Nqe = new nqe(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Nqe);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new nqc(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303954));
    this.b = ((LinearLayout)findViewById(2131303961));
    this.b.setOnClickListener(this);
    rue.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, aciy.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    rue.a(this.jdField_a_of_type_AndroidWidgetListView, aciy.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, nqd paramnqd, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Nqd = paramnqd;
    this.jdField_a_of_type_Nqe.notifyDataSetChanged();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        paramnqd = (GiftServiceBean)paramList.get(i);
        if ((!TextUtils.isEmpty(paramnqd.t)) && (paramnqd.t.equals(paramString))) {
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
    default: 
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqb
 * JD-Core Version:    0.7.0.1
 */