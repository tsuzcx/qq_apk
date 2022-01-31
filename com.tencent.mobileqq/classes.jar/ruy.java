import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;

class ruy
  extends ruj
{
  ruy(rus paramrus) {}
  
  protected boolean a(Integer paramInteger)
  {
    rux localrux = rus.a(this.a, paramInteger.intValue());
    if (localrux == null) {
      return false;
    }
    if (localrux.jdField_a_of_type_Boolean)
    {
      this.a.b(localrux.jdField_a_of_type_JavaLangString);
      return true;
    }
    if (paramInteger.intValue() == 1) {
      this.a.b(localrux.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return super.a(paramInteger);
      if (paramInteger.intValue() == 2)
      {
        rus.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 3)
      {
        rus.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 4)
      {
        rus.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 5)
      {
        rus.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 6)
      {
        rus.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 7)
      {
        rus.a(this.a).a(rus.a(this.a).c);
        rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 8)
      {
        rus.a(this.a).b(rus.a(this.a).c);
        rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 9)
      {
        rus.a(this.a).c();
        rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 10)
      {
        rus.a(this.a).a(this.a);
        rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 12)
      {
        rus.a(this.a);
        rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 28)
      {
        if (!TextUtils.isEmpty(rus.a(this.a).c))
        {
          axea.a(1, 3);
          axea.a(rus.a(this.a).c, rus.a(this.a).jdField_a_of_type_JavaLangString);
          rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
        }
      }
      else if (paramInteger.intValue() == 13)
      {
        if (!TextUtils.isEmpty(rus.a(this.a).c)) {
          this.a.a.d(rus.a(this.a).c, new ruz(this, localrux));
        }
      }
      else if (paramInteger.intValue() == 14)
      {
        rus.a(this.a).c(rus.a(this.a).c);
        rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 20)
      {
        rus.b(this.a);
        rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
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
          if (!TextUtils.isEmpty(rus.a(this.a).e))
          {
            localIntent = AddFriendLogicActivity.a(this.a.a(), 1, rus.a(this.a).e + "", null, 3096, 1, rus.a(this.a).f, null, null, null, null);
            this.a.a().startActivity(localIntent);
          }
          rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
        }
        else if (paramInteger.intValue() == 16)
        {
          if (!TextUtils.isEmpty(rus.a(this.a).e))
          {
            localIntent = aciy.a(new Intent(this.a.a(), SplashActivity.class), null);
            localIntent.putExtra("uin", rus.a(this.a).e);
            localIntent.putExtra("uintype", 0);
            this.a.a().startActivity(localIntent);
            rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
          }
        }
        else if (paramInteger.intValue() == 21)
        {
          if (!TextUtils.isEmpty(rus.a(this.a).e))
          {
            localIntent = new Intent(this.a.a(), AccountDetailActivity.class);
            localIntent.putExtra("uin", rus.a(this.a).e);
            localIntent.putExtra("from_js", true);
            this.a.a().startActivity(localIntent);
            rus.a(this.a, localrux.jdField_a_of_type_JavaLangString, true);
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
          this.a.b(localrux.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ruy
 * JD-Core Version:    0.7.0.1
 */