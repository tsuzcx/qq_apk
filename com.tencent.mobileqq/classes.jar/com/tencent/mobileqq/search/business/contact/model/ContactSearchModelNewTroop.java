package com.tencent.mobileqq.search.business.contact.model;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import java.util.Set;

public class ContactSearchModelNewTroop
  extends ContactSearchModelGlobalTroop
{
  private CharSequence c;
  
  public ContactSearchModelNewTroop(AppInterface paramAppInterface, int paramInt, String paramString, List<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> paramList)
  {
    super(paramAppInterface, paramInt, paramString, paramList);
  }
  
  public TroopInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  }
  
  protected void a()
  {
    int j;
    int i;
    int k;
    int m;
    if (SearchUtils.a(this.jdField_b_of_type_Int))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localSpannableStringBuilder.append("包含: ");
        j = this.jdField_b_of_type_JavaUtilList.size() - 1;
        i = 0;
        for (;;)
        {
          if (j >= 0) {
            k = 1;
          } else {
            k = 0;
          }
          if (i < 10) {
            m = 1;
          } else {
            m = 0;
          }
          if ((k & m) == 0) {
            break;
          }
          localSpannableStringBuilder.append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(j), (String)this.jdField_c_of_type_JavaUtilList.get(j), 6, false));
          i += 1;
          localSpannableStringBuilder.append("、");
          j -= 1;
        }
        k = 0;
        j = i;
        i = k;
        for (;;)
        {
          if (i < this.jdField_a_of_type_JavaUtilList.size()) {
            k = 1;
          } else {
            k = 0;
          }
          if (j < 10) {
            m = 1;
          } else {
            m = 0;
          }
          if ((k & m) == 0) {
            break;
          }
          localObject = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          k = j;
          if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
          {
            if (this.jdField_c_of_type_JavaUtilList.size() == 1) {
              m = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).a;
            } else {
              m = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_Int;
            }
            if (m == 66)
            {
              localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).c;
            }
            else if (m == 88)
            {
              localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).jdField_b_of_type_JavaLangString;
            }
            else
            {
              k = j;
              if (m != 99) {
                break label327;
              }
              localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).d;
            }
            k = j;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              k = j + 1;
              localSpannableStringBuilder.append((CharSequence)localObject);
              localSpannableStringBuilder.append("、");
            }
          }
          label327:
          i += 1;
          j = k;
        }
      }
      if ((localSpannableStringBuilder.length() > 0) && (localSpannableStringBuilder.charAt(localSpannableStringBuilder.length() - 1) == '、')) {
        this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1);
      } else {
        this.jdField_a_of_type_JavaLangCharSequence = localSpannableStringBuilder;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131702724));
      this.jdField_c_of_type_JavaLangCharSequence = ((StringBuilder)localObject).toString();
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = HardCodeUtil.a(2131702733);
    Object localObject = new SpannableStringBuilder();
    if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopName())
    {
      ((SpannableStringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum));
    }
    else if ((!this.jdField_a_of_type_JavaUtilSet.isEmpty()) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      i = this.jdField_b_of_type_JavaUtilList.size() - 1;
      j = 0;
      for (;;)
      {
        if (i >= 0) {
          k = 1;
        } else {
          k = 0;
        }
        if (j < 10) {
          m = 1;
        } else {
          m = 0;
        }
        if ((k & m) == 0) {
          break;
        }
        ((SpannableStringBuilder)localObject).append(SearchUtils.a((String)this.jdField_b_of_type_JavaUtilList.get(i), (String)this.jdField_c_of_type_JavaUtilList.get(i), 6, false));
        j += 1;
        if (i > 0) {
          ((SpannableStringBuilder)localObject).append("、");
        }
        i -= 1;
      }
    }
    this.jdField_c_of_type_JavaLangCharSequence = ((CharSequence)localObject);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!SearchUtils.a(this.jdField_b_of_type_Int)) {
      SearchUtils.a(paramView, this);
    }
  }
  
  public CharSequence b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopName())) {
      return c();
    }
    return super.b();
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangCharSequence.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop
 * JD-Core Version:    0.7.0.1
 */