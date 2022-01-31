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

public class obj
  extends Dialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private obl jdField_a_of_type_Obl;
  private obm jdField_a_of_type_Obm;
  private LinearLayout b;
  
  public obj(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755326);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131559946);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131369615));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369626));
    this.jdField_a_of_type_Obm = new obm(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Obm);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new obk(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369626));
    this.b = ((LinearLayout)findViewById(2131369633));
    this.b.setOnClickListener(this);
    sgt.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, actj.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    sgt.a(this.jdField_a_of_type_AndroidWidgetListView, actj.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, obl paramobl, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Obl = paramobl;
    this.jdField_a_of_type_Obm.notifyDataSetChanged();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        paramobl = (GiftServiceBean)paramList.get(i);
        if ((!TextUtils.isEmpty(paramobl.t)) && (paramobl.t.equals(paramString))) {
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
 * Qualified Name:     obj
 * JD-Core Version:    0.7.0.1
 */