import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.biz.JoinGroupHandler.2;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;

public class njc
{
  protected int a;
  protected long a;
  protected Context a;
  protected aojs a;
  public bjbs a;
  protected QQAppInterface a;
  protected Runnable a;
  protected String a;
  protected njf a;
  protected long b;
  
  public njc(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, njf paramnjf)
  {
    this.jdField_a_of_type_JavaLangRunnable = new JoinGroupHandler.2(this);
    this.jdField_a_of_type_Aojs = new nje(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Njf = paramnjf;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new bjcf(this.jdField_a_of_type_AndroidContentContext).a(paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011), 0, paramInt2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.jdField_a_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.jdField_a_of_type_JavaLangString, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopInfo);
      this.jdField_a_of_type_Njf.b();
      return;
    }
    a(2131718941, 1);
    this.jdField_a_of_type_Njf.a();
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing()))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.b;
        if ((!paramBoolean) && (l1 - l2 < 1000L))
        {
          ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
          return;
        }
        this.jdField_a_of_type_Bjbs.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(long paramLong)
  {
    try
    {
      aoip localaoip = (aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      this.jdField_a_of_type_Long = paramLong;
      localaoip.a(paramLong, 8390784);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(2131718517, 0);
      this.jdField_a_of_type_Njf.a();
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Bjbs == null)
      {
        this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        this.jdField_a_of_type_Bjbs.c(2131694176);
        this.jdField_a_of_type_Bjbs.c(false);
        this.jdField_a_of_type_Bjbs.setOnDismissListener(new njd(this));
      }
      this.jdField_a_of_type_Bjbs.show();
      this.b = System.currentTimeMillis();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
  }
  
  public void a(long paramLong)
  {
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131693963, 0);
      this.jdField_a_of_type_Njf.a();
      return;
    }
    if (0L == paramLong)
    {
      this.jdField_a_of_type_Njf.a();
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    c();
    b(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     njc
 * JD-Core Version:    0.7.0.1
 */