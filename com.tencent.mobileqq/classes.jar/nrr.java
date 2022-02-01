import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.biz.JoinGroupHandler.2;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;

public class nrr
{
  protected int a;
  protected long a;
  protected Context a;
  protected aofu a;
  public bisl a;
  protected QQAppInterface a;
  protected Runnable a;
  protected String a;
  protected nru a;
  protected long b;
  
  public nrr(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, nru paramnru)
  {
    this.jdField_a_of_type_JavaLangRunnable = new JoinGroupHandler.2(this);
    this.jdField_a_of_type_Aofu = new nrt(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Nru = paramnru;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    new bisy(this.jdField_a_of_type_AndroidContentContext).a(paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080), 0, paramInt2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.jdField_a_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.jdField_a_of_type_JavaLangString, null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopInfo);
      this.jdField_a_of_type_Nru.b();
      return;
    }
    a(2131719621, 1);
    this.jdField_a_of_type_Nru.a();
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.b;
        if ((!paramBoolean) && (l1 - l2 < 1000L))
        {
          ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
          return;
        }
        this.jdField_a_of_type_Bisl.dismiss();
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
      aoep localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      this.jdField_a_of_type_Long = paramLong;
      localaoep.a(paramLong, 8390784);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(2131719155, 0);
      this.jdField_a_of_type_Nru.a();
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Bisl == null)
      {
        this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
        this.jdField_a_of_type_Bisl.c(2131694477);
        this.jdField_a_of_type_Bisl.c(false);
        this.jdField_a_of_type_Bisl.setOnDismissListener(new nrs(this));
      }
      this.jdField_a_of_type_Bisl.show();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  public void a(long paramLong)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131694253, 0);
      this.jdField_a_of_type_Nru.a();
      return;
    }
    if (0L == paramLong)
    {
      this.jdField_a_of_type_Nru.a();
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    c();
    b(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nrr
 * JD-Core Version:    0.7.0.1
 */