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
  private CharSequence i;
  
  public ContactSearchModelNewTroop(AppInterface paramAppInterface, int paramInt, String paramString, List<ContactSearchModelGlobalTroop.TroopSearchMemberInfo> paramList)
  {
    super(paramAppInterface, paramInt, paramString, paramList);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (!SearchUtils.b(this.n)) {
      SearchUtils.a(paramView, this);
    }
  }
  
  public CharSequence d()
  {
    if ((this.h.isNewTroop()) && (!this.h.hasSetTroopName())) {
      return m();
    }
    return super.d();
  }
  
  public String n()
  {
    return this.i.toString();
  }
  
  protected void s()
  {
    int k;
    int j;
    int m;
    int n;
    if (SearchUtils.b(this.n))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (this.b != null)
      {
        localSpannableStringBuilder.append("包含: ");
        k = this.e.size() - 1;
        j = 0;
        for (;;)
        {
          if (k >= 0) {
            m = 1;
          } else {
            m = 0;
          }
          if (j < 10) {
            n = 1;
          } else {
            n = 0;
          }
          if ((m & n) == 0) {
            break;
          }
          localSpannableStringBuilder.append(SearchUtils.a((String)this.e.get(k), (String)this.f.get(k), 6, false));
          j += 1;
          localSpannableStringBuilder.append("、");
          k -= 1;
        }
        m = 0;
        k = j;
        j = m;
        for (;;)
        {
          if (j < this.b.size()) {
            m = 1;
          } else {
            m = 0;
          }
          if (k < 10) {
            n = 1;
          } else {
            n = 0;
          }
          if ((m & n) == 0) {
            break;
          }
          localObject = (ContactSearchModelGlobalTroop.TroopSearchMemberInfo)this.b.get(j);
          m = k;
          if (!this.g.contains(localObject))
          {
            if (this.f.size() == 1) {
              n = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).f;
            } else {
              n = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).g;
            }
            if (n == 66)
            {
              localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).c;
            }
            else if (n == 88)
            {
              localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).b;
            }
            else
            {
              m = k;
              if (n != 99) {
                break label327;
              }
              localObject = ((ContactSearchModelGlobalTroop.TroopSearchMemberInfo)localObject).d;
            }
            m = k;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              m = k + 1;
              localSpannableStringBuilder.append((CharSequence)localObject);
              localSpannableStringBuilder.append("、");
            }
          }
          label327:
          j += 1;
          k = m;
        }
      }
      if ((localSpannableStringBuilder.length() > 0) && (localSpannableStringBuilder.charAt(localSpannableStringBuilder.length() - 1) == '、')) {
        this.d = localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1);
      } else {
        this.d = localSpannableStringBuilder;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.h.wMemberNum);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131900714));
      this.i = ((StringBuilder)localObject).toString();
      return;
    }
    this.d = HardCodeUtil.a(2131900723);
    Object localObject = new SpannableStringBuilder();
    if (!this.h.hasSetTroopName())
    {
      ((SpannableStringBuilder)localObject).append(String.valueOf(this.h.wMemberNum));
    }
    else if ((!this.g.isEmpty()) && (this.b != null))
    {
      j = this.e.size() - 1;
      k = 0;
      for (;;)
      {
        if (j >= 0) {
          m = 1;
        } else {
          m = 0;
        }
        if (k < 10) {
          n = 1;
        } else {
          n = 0;
        }
        if ((m & n) == 0) {
          break;
        }
        ((SpannableStringBuilder)localObject).append(SearchUtils.a((String)this.e.get(j), (String)this.f.get(j), 6, false));
        k += 1;
        if (j > 0) {
          ((SpannableStringBuilder)localObject).append("、");
        }
        j -= 1;
      }
    }
    this.i = ((CharSequence)localObject);
  }
  
  public TroopInfo t()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelNewTroop
 * JD-Core Version:    0.7.0.1
 */