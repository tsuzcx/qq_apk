import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RequestFetchRunnable;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class lsc
  implements lsj
{
  public lsc(RandomController paramRandomController) {}
  
  public void a(int paramInt, lsp paramlsp)
  {
    if (this.a.jdField_a_of_type_Ley == null) {}
    label517:
    label1010:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("RandomController", 2, "rsp.rsptype = " + paramlsp.a + ", errCode = " + paramInt);
            }
            if ((paramlsp.a == 1) || (paramlsp.a == 2))
            {
              switch (paramInt)
              {
              case -2: 
              default: 
                RandomController.b(this.a);
                return;
              case 1: 
                if (RandomController.a(this.a).get() >= 3)
                {
                  RandomController.a(this.a);
                  return;
                }
                paramlsp = (lsq)paramlsp;
                RandomController.a(this.a).a(paramlsp);
                RandomController.a(this.a).a().postDelayed(RandomController.a(this.a), paramlsp.h);
                return;
              case 0: 
                RandomController.a(this.a, paramlsp);
                return;
              case -1: 
                RandomController.a(this.a);
                return;
              }
              RandomController.b(this.a, paramlsp);
              return;
            }
            if ((paramlsp.a == -100) || (paramlsp.a == 3))
            {
              if (RandomController.a(this.a) == 1)
              {
                if ((paramInt == 0) && ((paramlsp instanceof lsr)))
                {
                  paramlsp = (lsr)paramlsp;
                  this.a.jdField_a_of_type_Ley.a.a = paramlsp.a;
                  if (this.a.jdField_a_of_type_Ley.l())
                  {
                    paramlsp = RandomController.a(this.a).iterator();
                    while (paramlsp.hasNext()) {
                      ((lsi)paramlsp.next()).a();
                    }
                  }
                }
              }
              else if (RandomController.a(this.a) == 2)
              {
                Object localObject2;
                Object localObject1;
                if ((paramInt == 0) && ((paramlsp instanceof lst)))
                {
                  localObject2 = (lst)paramlsp;
                  if (((lst)localObject2).f != 0) {
                    if (((lst)localObject2).f != 2) {
                      break label517;
                    }
                  }
                  for (localObject1 = ((lst)localObject2).e;; localObject1 = String.valueOf(((lst)localObject2).jdField_a_of_type_Long))
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      lco locallco = RandomController.a(this.a).a((String)localObject1);
                      if (locallco != null)
                      {
                        locallco.c = ((lst)localObject2).c;
                        RandomController.a(this.a).a((String)localObject1, ((lst)localObject2).b, ((lst)localObject2).c);
                        if (QLog.isColorLevel()) {
                          QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + locallco.jdField_a_of_type_Long + ", headUrl:" + locallco.c);
                        }
                      }
                    }
                    localObject1 = RandomController.a(this.a).iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((lsi)((Iterator)localObject1).next()).a();
                    }
                  }
                }
                if (paramInt == 100)
                {
                  localObject2 = RandomController.a(this.a).c();
                  localObject1 = new StringBuilder();
                  localObject2 = ((ArrayList)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((StringBuilder)localObject1).append(((lco)((Iterator)localObject2).next()).jdField_a_of_type_Long).append("|");
                  }
                  if ((!this.a.jdField_b_of_type_Boolean) && (RandomController.a(this.a) != null)) {
                    RandomController.a(this.a).a(RandomController.b(this.a), 5, ((StringBuilder)localObject1).toString(), this.a.a(RandomController.a(this.a).getAccount()), this.a.jdField_a_of_type_Long);
                  }
                }
                if ((paramlsp instanceof lst))
                {
                  paramlsp = (lst)paramlsp;
                  if ((!TextUtils.isEmpty(paramlsp.d)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_Ley.a.e)))
                  {
                    this.a.jdField_a_of_type_Ley.a.e = (RandomController.a(this.a).getApp().getString(2131695091) + " “" + paramlsp.d + "” ");
                    RandomController.a(this.a, paramlsp.d);
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.a.jdField_a_of_type_Ley.a.e);
                    }
                  }
                }
              }
              if (paramInt == -3)
              {
                paramlsp = RandomController.a(this.a).iterator();
                while (paramlsp.hasNext()) {
                  ((lsi)paramlsp.next()).a();
                }
              }
            }
            else
            {
              if ((!(paramlsp instanceof lsu)) || (paramlsp.a != 5)) {
                break label1010;
              }
              if (paramInt != 0) {
                break;
              }
              paramlsp = (lsu)paramlsp;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "request room owner room owner change push，uin " + paramlsp.b + " [random room owner]");
              }
              this.a.jdField_b_of_type_Int = 5;
              this.a.g = paramlsp.b;
              paramlsp = RandomController.a(this.a).iterator();
              while (paramlsp.hasNext()) {
                ((lsi)paramlsp.next()).a();
              }
            }
          }
        } while ((paramInt != -4) || (!QLog.isColorLevel()));
        QLog.e("RandomController", 2, "[random room owner] pull room fail fail");
        return;
      } while ((!(paramlsp instanceof lsu)) || (4 != paramlsp.a));
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] RSP_MULTI_KICK_MEMBER");
      }
      RandomController.a(this.a).a().removeCallbacks(RandomController.a(this.a));
      RandomController.a(this.a, false);
      paramlsp = (lsu)paramlsp;
      long l = paramlsp.jdField_a_of_type_OrgJsonJSONObject.optInt("groupid");
      this.a.jdField_a_of_type_JavaLangString = bgmj.a(paramlsp.jdField_a_of_type_OrgJsonJSONObject.optString("wording").trim());
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = RandomController.a(this.a).getApp().getApplicationContext().getString(2131695084);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] KICK_MEMBER success groupId = " + l + ", mCurrGroupId = " + this.a.jdField_a_of_type_Long);
      }
      if (l == this.a.jdField_a_of_type_Long)
      {
        if (paramInt == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RandomController", 2, "[random room owner] KICK_MEMBER success");
          }
          this.a.jdField_b_of_type_Int = 6;
        }
        for (;;)
        {
          paramlsp = RandomController.a(this.a).iterator();
          while (paramlsp.hasNext()) {
            ((lsi)paramlsp.next()).a();
          }
          break;
          if (paramInt == -4)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RandomController", 2, "[random room owner] KICK_MEMBER fail" + paramlsp.jdField_a_of_type_JavaLangString);
            }
            this.a.jdField_b_of_type_Int = 7;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "KICK_MEMBER success groupid != mCurrGroupId  [random room owner]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lsc
 * JD-Core Version:    0.7.0.1
 */