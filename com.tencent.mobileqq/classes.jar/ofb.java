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

public class ofb
  extends Dialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ofd jdField_a_of_type_Ofd;
  private ofe jdField_a_of_type_Ofe;
  private LinearLayout b;
  
  public ofb(Context paramContext, int paramInt)
  {
    super(paramContext, 2131755332);
    requestWindowFeature(1);
    getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
    setContentView(2131560043);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131369898));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369909));
    this.jdField_a_of_type_Ofe = new ofe(this);
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Ofe);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new ofc(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369909));
    this.b = ((LinearLayout)findViewById(2131369915));
    this.b.setOnClickListener(this);
    syo.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, aepi.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    syo.a(this.jdField_a_of_type_AndroidWidgetListView, aepi.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
    setCanceledOnTouchOutside(true);
  }
  
  public void a(List<GiftServiceBean> paramList, ofd paramofd, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Ofd = paramofd;
    this.jdField_a_of_type_Ofe.notifyDataSetChanged();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        paramofd = (GiftServiceBean)paramList.get(i);
        if ((!TextUtils.isEmpty(paramofd.t)) && (paramofd.t.equals(paramString))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ofb
 * JD-Core Version:    0.7.0.1
 */