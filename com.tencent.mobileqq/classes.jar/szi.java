import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;

class szi
  extends syt
{
  szi(szc paramszc) {}
  
  protected boolean a(Integer paramInteger)
  {
    szh localszh = szc.a(this.a, paramInteger.intValue());
    if (localszh == null) {
      return false;
    }
    if (localszh.jdField_a_of_type_Boolean)
    {
      this.a.b(localszh.jdField_a_of_type_JavaLangString);
      return true;
    }
    if (paramInteger.intValue() == 1) {
      this.a.b(localszh.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return super.a(paramInteger);
      if (paramInteger.intValue() == 2)
      {
        szc.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 3)
      {
        szc.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 4)
      {
        szc.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 5)
      {
        szc.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 6)
      {
        szc.a(this.a, paramInteger.intValue());
      }
      else if (paramInteger.intValue() == 7)
      {
        szc.a(this.a).a(szc.a(this.a).c);
        szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 8)
      {
        szc.a(this.a).b(szc.a(this.a).c);
        szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 9)
      {
        szc.a(this.a).c();
        szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 10)
      {
        szc.a(this.a).a(this.a);
        szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 12)
      {
        szc.a(this.a);
        szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 28)
      {
        if (!TextUtils.isEmpty(szc.a(this.a).c))
        {
          bagk.a(1, 3);
          bagk.a(szc.a(this.a).c, szc.a(this.a).jdField_a_of_type_JavaLangString);
          szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
        }
      }
      else if (paramInteger.intValue() == 13)
      {
        if (!TextUtils.isEmpty(szc.a(this.a).c)) {
          this.a.a.d(szc.a(this.a).c, new szj(this, localszh));
        }
      }
      else if (paramInteger.intValue() == 14)
      {
        szc.a(this.a).c(szc.a(this.a).c);
        szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
      }
      else if (paramInteger.intValue() == 20)
      {
        szc.b(this.a);
        szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
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
          if (!TextUtils.isEmpty(szc.a(this.a).e))
          {
            localIntent = AddFriendLogicActivity.a(this.a.a(), 1, szc.a(this.a).e + "", null, 3096, 1, szc.a(this.a).f, null, null, null, null);
            this.a.a().startActivity(localIntent);
          }
          szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
        }
        else if (paramInteger.intValue() == 16)
        {
          if (!TextUtils.isEmpty(szc.a(this.a).e))
          {
            localIntent = aepi.a(new Intent(this.a.a(), SplashActivity.class), null);
            localIntent.putExtra("uin", szc.a(this.a).e);
            localIntent.putExtra("uintype", 0);
            this.a.a().startActivity(localIntent);
            szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
          }
        }
        else if (paramInteger.intValue() == 21)
        {
          if (!TextUtils.isEmpty(szc.a(this.a).e))
          {
            localIntent = new Intent(this.a.a(), AccountDetailActivity.class);
            localIntent.putExtra("uin", szc.a(this.a).e);
            localIntent.putExtra("from_js", true);
            this.a.a().startActivity(localIntent);
            szc.a(this.a, localszh.jdField_a_of_type_JavaLangString, true);
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
          this.a.b(localszh.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     szi
 * JD-Core Version:    0.7.0.1
 */