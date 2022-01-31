import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.biz.JoinGroupHandler.2;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;

public class mkz
{
  protected int a;
  protected long a;
  protected ajuc a;
  protected Context a;
  public bbms a;
  protected QQAppInterface a;
  protected Runnable a;
  protected String a;
  protected mlc a;
  protected long b;
  
  public mkz(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, mlc parammlc)
  {
    this.jdField_a_of_type_JavaLangRunnable = new JoinGroupHandler.2(this);
    this.jdField_a_of_type_Ajuc = new mlb(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Mlc = parammlc;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new bbne(this.jdField_a_of_type_AndroidContentContext).a(paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766), 0, paramInt2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.jdField_a_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.jdField_a_of_type_JavaLangString, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopInfo);
      this.jdField_a_of_type_Mlc.b();
      return;
    }
    a(2131654599, 1);
    this.jdField_a_of_type_Mlc.a();
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.b;
        if ((!paramBoolean) && (l1 - l2 < 1000L))
        {
          ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
          return;
        }
        this.jdField_a_of_type_Bbms.dismiss();
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
      ajtg localajtg = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      this.jdField_a_of_type_Long = paramLong;
      localajtg.a(paramLong, 8390784);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(2131654104, 0);
      this.jdField_a_of_type_Mlc.a();
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Bbms == null)
      {
        this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        this.jdField_a_of_type_Bbms.c(2131629253);
        this.jdField_a_of_type_Bbms.c(false);
        this.jdField_a_of_type_Bbms.setOnDismissListener(new mla(this));
      }
      this.jdField_a_of_type_Bbms.show();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
  }
  
  public void a(long paramLong)
  {
    if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131628946, 0);
      this.jdField_a_of_type_Mlc.a();
      return;
    }
    if (0L == paramLong)
    {
      this.jdField_a_of_type_Mlc.a();
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    c();
    b(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkz
 * JD-Core Version:    0.7.0.1
 */