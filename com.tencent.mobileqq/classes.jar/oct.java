import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;

public class oct
  extends obj
{
  public oct(Context paramContext, ArrayList<oji> paramArrayList, oat paramoat, String paramString1, String paramString2)
  {
    super(paramContext, paramArrayList, paramoat, paramString1, paramString2);
  }
  
  public static View a(Context paramContext, View paramView, ViewGroup paramViewGroup, ojh paramojh, int paramInt, oat paramoat, String paramString1, String paramString2)
  {
    paramojh = a(paramojh, paramInt);
    if (paramojh.isEmpty())
    {
      paramContext = paramView;
      if (QLog.isDevelopLevel())
      {
        QLog.d("AccountDetailWindowViewWrapper", 2, "createView return convertView!");
        paramContext = paramView;
      }
    }
    do
    {
      return paramContext;
      if ((paramView == null) || (!(paramView instanceof LinearLayout))) {
        break;
      }
      paramView = (LinearLayout)paramView;
      Object localObject = paramView.getTag();
      if ((localObject == null) || (!(localObject instanceof oct)) || (!((oct)localObject).a(paramojh))) {
        break;
      }
      paramContext = paramView;
    } while (!QLog.isDevelopLevel());
    QLog.d("AccountDetailWindowViewWrapper", 2, "createView reuse!");
    return paramView;
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailWindowViewWrapper", 2, "createView new create!");
    }
    paramView = (LinearLayout)LayoutInflater.from(paramContext).inflate(2131558410, paramViewGroup, false);
    paramView.setPadding(0, AIOUtils.dp2px(20.0F, paramViewGroup.getResources()), 0, 0);
    paramContext = new oct(paramContext, paramojh, paramoat, paramString1, paramString2);
    paramView.setTag(paramContext);
    paramContext.a(paramView);
    return paramView;
  }
  
  @TargetApi(9)
  private void a(LinearLayout paramLinearLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailWindowViewWrapper", 2, "buildView!");
    }
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = AIOUtils.dp2px(140.0F, (Resources)localObject);
    int j = AIOUtils.dp2px(10.0F, (Resources)localObject);
    if (Build.VERSION.SDK_INT >= 9) {
      ((HorizontalScrollView)paramLinearLayout.findViewById(2131381489)).setOverScrollMode(2);
    }
    localObject = (GridView)paramLinearLayout.findViewById(2131381480);
    ((GridView)localObject).setClickable(true);
    ((GridView)localObject).setColumnWidth(i);
    ((GridView)localObject).setStretchMode(0);
    ((GridView)localObject).setHorizontalSpacing(j);
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    ((GridView)localObject).setLayoutParams(new LinearLayout.LayoutParams((i + j) * k - j, -2));
    ((GridView)localObject).setNumColumns(k);
    ((GridView)localObject).setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    if (Build.VERSION.SDK_INT >= 9) {
      ((GridView)localObject).setOverScrollMode(2);
    }
    ((GridView)localObject).setAdapter(new ocu(this));
    paramLinearLayout.setClickable(false);
    paramLinearLayout.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oct
 * JD-Core Version:    0.7.0.1
 */