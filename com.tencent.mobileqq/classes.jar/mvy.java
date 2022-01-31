import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.biz.JoinGroupHandler.2;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;

public class mvy
{
  protected int a;
  protected long a;
  protected akim a;
  protected Context a;
  public bcpq a;
  protected QQAppInterface a;
  protected Runnable a;
  protected String a;
  protected mwb a;
  protected long b;
  
  public mvy(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, mwb parammwb)
  {
    this.jdField_a_of_type_JavaLangRunnable = new JoinGroupHandler.2(this);
    this.jdField_a_of_type_Akim = new mwa(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Mwb = parammwb;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new bcqc(this.jdField_a_of_type_AndroidContentContext).a(paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865), 0, paramInt2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.jdField_a_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.jdField_a_of_type_JavaLangString, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopInfo);
      this.jdField_a_of_type_Mwb.b();
      return;
    }
    a(2131720495, 1);
    this.jdField_a_of_type_Mwb.a();
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing()))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.b;
        if ((!paramBoolean) && (l1 - l2 < 1000L))
        {
          ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
          return;
        }
        this.jdField_a_of_type_Bcpq.dismiss();
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
      akhq localakhq = (akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      this.jdField_a_of_type_Long = paramLong;
      localakhq.a(paramLong, 8390784);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(2131719993, 0);
      this.jdField_a_of_type_Mwb.a();
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Bcpq == null)
      {
        this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        this.jdField_a_of_type_Bcpq.c(2131694930);
        this.jdField_a_of_type_Bcpq.c(false);
        this.jdField_a_of_type_Bcpq.setOnDismissListener(new mvz(this));
      }
      this.jdField_a_of_type_Bcpq.show();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akim);
  }
  
  public void a(long paramLong)
  {
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131694607, 0);
      this.jdField_a_of_type_Mwb.a();
      return;
    }
    if (0L == paramLong)
    {
      this.jdField_a_of_type_Mwb.a();
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    c();
    b(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akim);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mvy
 * JD-Core Version:    0.7.0.1
 */