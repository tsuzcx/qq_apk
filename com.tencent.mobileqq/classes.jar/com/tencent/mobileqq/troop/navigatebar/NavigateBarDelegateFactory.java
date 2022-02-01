package com.tencent.mobileqq.troop.navigatebar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.widget.URLThemeImageView;
import java.util.List;

public class NavigateBarDelegateFactory
  implements INavigateBar
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<BaseTroopAioMsgNavigateBarDelegate> jdField_a_of_type_AndroidUtilSparseArray;
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopAioMsgNavigateBar jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar;
  
  NavigateBarDelegateFactory(QQAppInterface paramQQAppInterface, Context paramContext, TroopAioMsgNavigateBar paramTroopAioMsgNavigateBar, BaseSessionInfo paramBaseSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar = paramTroopAioMsgNavigateBar;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    a();
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      return ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).a(paramInt);
    }
    return 0;
  }
  
  @Nullable
  public BaseTroopAioMsgNavigateBarDelegate.Entity a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1) != null) {
      return ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1)).a(paramInt1, paramList, paramLong1, paramObject, paramLong2, paramLong3, paramInt2);
    }
    return null;
  }
  
  public BaseTroopAioMsgNavigateBarDelegate a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      return ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).a(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    Object localObject = new TroopAioMsgNavigateArk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateAtAll(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateAtMe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateCalendar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateConfessToMe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateDingDongAtMe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateEffectPic(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateFlowers(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateFocusWord(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateGameParty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateHomeWork(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateHomeworkPraise(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateNewAblum(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateNewFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateReceipt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateReply(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateShopArk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateSpecial(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateSticker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateUnRead(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    localObject = new TroopAioMsgNavigateNotification(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopNavigatebarTroopAioMsgNavigateBar, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(((BaseTroopAioMsgNavigateBarDelegate)localObject).a(), localObject);
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a();
      i += 1;
    }
  }
  
  public void a(int paramInt, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView, String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).a(paramInt, paramTextView1, paramTextView2, paramImageView, paramString);
    }
  }
  
  public void a(int paramInt1, TroopAioAgent.Message paramMessage, String paramString, int paramInt2, TextView paramTextView1, TextView paramTextView2, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1) != null) {
      ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1)).a(paramInt1, paramMessage, paramString, paramInt2, paramTextView1, paramTextView2, paramLong);
    }
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).a(paramInt, paramObject, paramString);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      return ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).a(paramInt);
    }
    return paramInt == 103;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1) != null) {
      return ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1)).a(paramInt1, paramInt2);
    }
    return false;
  }
  
  public boolean a(int paramInt, URLThemeImageView paramURLThemeImageView, String paramString)
  {
    paramInt = a(paramInt);
    if (paramInt != 0)
    {
      paramURLThemeImageView.setImageDrawable(null);
      paramURLThemeImageView.setImageResource(paramInt);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).b();
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((BaseTroopAioMsgNavigateBarDelegate)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).b(paramInt, paramObject, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.NavigateBarDelegateFactory
 * JD-Core Version:    0.7.0.1
 */