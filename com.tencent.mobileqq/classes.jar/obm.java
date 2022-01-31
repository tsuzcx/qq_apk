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

public class obm
  extends Dialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private obo jdField_a_of_type_Obo;
  private obp jdField_a_of_type_Obp;
  private LinearLayout b;
  
  public obm(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755326);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131559946);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131369616));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369627));
    this.jdField_a_of_type_Obp = new obp(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Obp);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new obn(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369627));
    this.b = ((LinearLayout)findViewById(2131369634));
    this.b.setOnClickListener(this);
    sgw.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, actn.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    sgw.a(this.jdField_a_of_type_AndroidWidgetListView, actn.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, obo paramobo, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Obo = paramobo;
    this.jdField_a_of_type_Obp.notifyDataSetChanged();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        paramobo = (GiftServiceBean)paramList.get(i);
        if ((!TextUtils.isEmpty(paramobo.t)) && (paramobo.t.equals(paramString))) {
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
 * Qualified Name:     obm
 * JD-Core Version:    0.7.0.1
 */