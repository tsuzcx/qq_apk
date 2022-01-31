import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;

class shn
  extends sgy
{
  shn(shh paramshh) {}
  
  protected boolean a(Integer paramInteger)
  {
    shm localshm = shh.a(this.a, paramInteger.intValue());
    if (localshm == null) {
      return false;
    }
    if (localshm.jdField_a_of_type_Boolean)
    {
      this.a.b(localshm.jdField_a_of_type_JavaLangString);
      return true;
    }
    if (paramInteger.intValue() == 1) {
      this.a.b(localshm.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return super.a(paramInteger);
      if (paramInteger.intValue() == 2)
      {
        shh.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 3)
      {
        shh.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 4)
      {
        shh.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 5)
      {
        shh.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 6)
      {
        shh.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 7)
      {
        shh.a(this.a).a(shh.a(this.a).c);
        shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 8)
      {
        shh.a(this.a).b(shh.a(this.a).c);
        shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 9)
      {
        shh.a(this.a).c();
        shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 10)
      {
        shh.a(this.a).a(this.a);
        shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 12)
      {
        shh.a(this.a);
        shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 28)
      {
        if (!TextUtils.isEmpty(shh.a(this.a).c))
        {
          ayee.a(1, 3);
          ayee.a(shh.a(this.a).c, shh.a(this.a).jdField_a_of_type_JavaLangString);
          shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
        }
      }
      else if (paramInteger.intValue() == 13)
      {
        if (!TextUtils.isEmpty(shh.a(this.a).c)) {
          this.a.a.d(shh.a(this.a).c, new sho(this, localshm));
        }
      }
      else if (paramInteger.intValue() == 14)
      {
        shh.a(this.a).c(shh.a(this.a).c);
        shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 20)
      {
        shh.b(this.a);
        shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 19)
      {
        this.a.b("not_care");
      }
      else
      {
        Intent localIntent;
        if (paramInteger.intValue() == 17)
        {
          if (!TextUtils.isEmpty(shh.a(this.a).e))
          {
            localIntent = AddFriendLogicActivity.a(this.a.a(), 1, shh.a(this.a).e + "", null, 3096, 1, shh.a(this.a).f, null, null, null, null);
            this.a.a().startActivity(localIntent);
          }
          shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
        }
        else if (paramInteger.intValue() == 16)
        {
          if (!TextUtils.isEmpty(shh.a(this.a).e))
          {
            localIntent = actj.a(new Intent(this.a.a(), SplashActivity.class), null);
            localIntent.putExtra("uin", shh.a(this.a).e);
            localIntent.putExtra("uintype", 0);
            this.a.a().startActivity(localIntent);
            shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
          }
        }
        else if (paramInteger.intValue() == 21)
        {
          if (!TextUtils.isEmpty(shh.a(this.a).e))
          {
            localIntent = new Intent(this.a.a(), AccountDetailActivity.class);
            localIntent.putExtra("uin", shh.a(this.a).e);
            localIntent.putExtra("from_js", true);
            this.a.a().startActivity(localIntent);
            shh.a(this.a, localshm.jdField_a_of_type_JavaLangString, true);
          }
        }
        else if (paramInteger.intValue() == 22)
        {
          this.a.b("personal_c2c");
        }
        else if (paramInteger.intValue() == 23)
        {
          this.a.b("unfollow");
        }
        else
        {
          this.a.b(localshm.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     shn
 * JD-Core Version:    0.7.0.1
 */