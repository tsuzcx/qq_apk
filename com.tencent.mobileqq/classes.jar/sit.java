import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class sit
  implements View.OnClickListener
{
  public sit(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (paramView == null) {
      paramView = "";
    }
    while (!this.a.g) {
      if (this.a.jdField_e_of_type_Int == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("type", this.a.jdField_a_of_type_Int);
        localIntent.putExtra("subtype", this.a.jdField_b_of_type_Int);
        this.a.d();
        if ((this.a.jdField_b_of_type_JavaLangString == null) || (this.a.jdField_b_of_type_JavaLangString.length() == 0))
        {
          if ((paramView == null) || (paramView.length() == 0))
          {
            EditInfoActivity.a(this.a);
            return;
            paramView = paramView.toString().trim();
          }
        }
        else {
          if ((paramView != null) && (paramView.length() != 0)) {
            break label227;
          }
        }
        label227:
        while (!this.a.jdField_b_of_type_JavaLangString.equals(paramView))
        {
          localObject1 = paramView;
          if (this.a.d != 3) {
            break;
          }
          if (!TextUtils.isEmpty(paramView))
          {
            localObject2 = paramView;
            if (paramView.length() >= 1) {}
          }
          else
          {
            localObject2 = "";
          }
          localObject1 = localObject2;
          if (!this.a.a((String)localObject2)) {
            break;
          }
          QQToast.a(this.a, this.a.getString(2131433659), 0).b(this.a.getTitleBarHeight());
          return;
        }
        EditInfoActivity.b(this.a);
        return;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
        localIntent.putExtra("result", paramView);
        this.a.a(localIntent);
        this.a.setResult(-1, localIntent);
        EditInfoActivity.c(this.a);
      }
      else
      {
        this.a.k();
        return;
      }
    }
    if (!NetworkUtil.d(this.a.app.getApplication().getApplicationContext()))
    {
      QQToast.a(this.a, 1, 2131434794, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (((TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (TextUtils.isEmpty(paramView))) || ((!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (this.a.jdField_b_of_type_JavaLangString.equals(paramView))))
    {
      EditInfoActivity.d(this.a);
      return;
    }
    Object localObject1 = new TroopMemberCardInfo();
    ((TroopMemberCardInfo)localObject1).name = paramView;
    ((TroopMemberCardInfo)localObject1).memberuin = this.a.f;
    ((TroopMemberCardInfo)localObject1).troopuin = this.a.jdField_e_of_type_JavaLangString;
    ((TroopMemberCardInfo)localObject1).email = "";
    ((TroopMemberCardInfo)localObject1).memo = "";
    ((TroopMemberCardInfo)localObject1).sex = -1;
    ((TroopMemberCardInfo)localObject1).tel = "";
    paramView = new ArrayList();
    paramView.add(localObject1);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(Integer.valueOf(1));
    Object localObject2 = (TroopHandler)this.a.app.a(20);
    if ((localObject2 != null) && (!TextUtils.isEmpty(this.a.jdField_e_of_type_JavaLangString)))
    {
      this.a.b(true);
      ((TroopHandler)localObject2).a(this.a.jdField_e_of_type_JavaLangString, paramView, (ArrayList)localObject1);
    }
    paramView = (TroopManager)this.a.app.getManager(51);
    int i;
    if (paramView != null)
    {
      paramView = paramView.a(this.a.jdField_e_of_type_JavaLangString);
      if (paramView != null) {
        if ((!TextUtils.isEmpty(paramView.troopowneruin)) && (paramView.troopowneruin.equalsIgnoreCase(this.a.app.getAccount()))) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.a.app, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, this.a.jdField_e_of_type_JavaLangString, i + "", "" + this.a.d, "");
      return;
      if ((!TextUtils.isEmpty(paramView.Administrator)) && (paramView.Administrator.contains(this.a.app.getAccount()))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sit
 * JD-Core Version:    0.7.0.1
 */