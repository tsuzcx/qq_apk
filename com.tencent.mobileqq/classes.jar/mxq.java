import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.av.wtogether.view.ChildPressEffectRelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;
import java.util.UUID;

class mxq
{
  public View a;
  public CheckBox a;
  public TextView a;
  public ChildPressEffectRelativeLayout a;
  public AsyncImageView a;
  public EllipsizingTextView a;
  public TextView b;
  
  public mxq(mxo parammxo, View paramView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewChildPressEffectRelativeLayout = ((ChildPressEffectRelativeLayout)paramView.findViewById(2131379629));
    this.jdField_a_of_type_ComTencentAvWtogetherViewChildPressEffectRelativeLayout.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131379634));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramView.findViewById(2131379635));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379632));
    this.b = ((TextView)paramView.findViewById(2131379641));
    this.b.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131366755));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  public void a(bfmo parambfmo, int paramInt, boolean paramBoolean)
  {
    label42:
    bfif localbfif;
    Object localObject1;
    label163:
    label174:
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (!TextUtils.isEmpty(parambfmo.jdField_a_of_type_JavaLangString))
    {
      this.b.setText(parambfmo.jdField_a_of_type_JavaLangString);
      this.b.setVisibility(0);
      if (paramInt != 0) {
        break label554;
      }
      this.b.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvWtogetherViewChildPressEffectRelativeLayout.setTag(2131373988, parambfmo);
      localbfif = parambfmo.jdField_a_of_type_Bfif;
      localObject1 = ((TroopManager)this.jdField_a_of_type_Mxo.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(parambfmo.jdField_a_of_type_Long + "", parambfmo.jdField_b_of_type_Long + "");
      if ((localObject1 == null) || (!ContactUtils.isValideName(((TroopMemberInfo)localObject1).troopnick, parambfmo.jdField_c_of_type_Long + ""))) {
        break label567;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label572;
      }
      localObject1 = ((TroopMemberInfo)localObject1).troopnick;
      if (parambfmo.jdField_c_of_type_Long <= 0L) {
        break label715;
      }
      localObject2 = String.valueOf(parambfmo.jdField_c_of_type_Long);
      localObject3 = bfmp.a();
      localObject4 = ((bfmp)localObject3).a((String)localObject2);
      if (localObject4 == null) {
        break label578;
      }
      paramInt = bfmp.a(this.jdField_a_of_type_Mxo.jdField_b_of_type_JavaLangString, (String)localObject1, parambfmo.jdField_c_of_type_JavaLangString, ((bbyj)localObject4).jdField_c_of_type_JavaLangString, ((bbyj)localObject4).d, parambfmo.d, ((bbyj)localObject4).jdField_a_of_type_JavaLangString, ((bbyj)localObject4).jdField_b_of_type_JavaLangString);
      localObject1 = bfmp.a((String)localObject1, parambfmo.jdField_c_of_type_JavaLangString, parambfmo.d, paramInt);
      label268:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label631;
      }
      if (!TextUtils.isEmpty(parambfmo.jdField_c_of_type_JavaLangString)) {
        break label622;
      }
      localObject1 = parambfmo.d;
      label292:
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      label304:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      for (;;)
      {
        if ((parambfmo.jdField_a_of_type_JavaUtilArrayList != null) && (parambfmo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject3 = (String)parambfmo.jdField_a_of_type_JavaUtilArrayList.get(0);
          if ((TextUtils.isEmpty(localbfif.jdField_c_of_type_JavaLangString)) || (!localbfif.jdField_c_of_type_JavaLangString.toLowerCase().contains(((String)localObject3).toLowerCase()))) {}
        }
        for (;;)
        {
          mxo.a(this.jdField_a_of_type_Mxo, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView, localbfif, (String)localObject3);
          localObject3 = localbfif.a();
          localObject4 = localbfif.m;
          mxo.a(this.jdField_a_of_type_Mxo, paramBoolean, localbfif, this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, parambfmo);
          parambfmo = mxo.a(this.jdField_a_of_type_Mxo, (String)localObject4, (String)localObject2, this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject1, (String)localObject3);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(parambfmo);
          parambfmo = new StringBuilder();
          parambfmo.append(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getText()).append(",").append((String)localObject3).append(",").append("来自").append(",").append((String)localObject1).append(",").append((String)localObject4);
          this.jdField_a_of_type_AndroidViewView.setContentDescription(parambfmo.toString());
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(localbfif.a.equals(mxo.a(this.jdField_a_of_type_Mxo)));
          return;
          this.b.setVisibility(8);
          break;
          label554:
          this.b.setTag(2131373988, parambfmo);
          break label42;
          label567:
          paramInt = 0;
          break label163;
          label572:
          localObject1 = null;
          break label174;
          label578:
          paramInt = bfmp.a(this.jdField_a_of_type_Mxo.jdField_b_of_type_JavaLangString, (String)localObject1, parambfmo.jdField_c_of_type_JavaLangString, null, null, parambfmo.d, null, null);
          localObject1 = bfmp.a((String)localObject1, parambfmo.jdField_c_of_type_JavaLangString, parambfmo.d, paramInt);
          break label268;
          label622:
          localObject1 = parambfmo.jdField_c_of_type_JavaLangString;
          break label292;
          label631:
          if ((paramInt == 1) || (paramInt == 4) || (paramInt == 7))
          {
            localObject3 = this.jdField_a_of_type_Mxo.jdField_b_of_type_JavaLangString;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break label304;
          }
          if ((paramInt != 5) && (paramInt != 6) && (paramInt != 2) && (paramInt != 3)) {
            break label799;
          }
          localObject3 = ((bfmp)localObject3).a(this.jdField_a_of_type_Mxo.jdField_b_of_type_JavaLangString, (String)localObject2);
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label304;
          label715:
          if (paramInt != 0) {}
          for (;;)
          {
            if ((parambfmo.jdField_a_of_type_JavaUtilArrayList == null) || (parambfmo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
              break label792;
            }
            localObject2 = (String)parambfmo.jdField_a_of_type_JavaUtilArrayList.get(0);
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).toLowerCase().contains(((String)localObject2).toLowerCase()))) {
              break label792;
            }
            break;
            localObject1 = parambfmo.jdField_b_of_type_JavaLangString;
          }
          localObject3 = "";
        }
        label792:
        localObject2 = "";
      }
      label799:
      localObject2 = localObject1;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxq
 * JD-Core Version:    0.7.0.1
 */