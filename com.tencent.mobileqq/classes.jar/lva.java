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

public class lva
  implements lvh
{
  public lva(RandomController paramRandomController) {}
  
  public void a(int paramInt, lvn paramlvn)
  {
    if (this.a.jdField_a_of_type_Lid == null) {}
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
              QLog.d("RandomController", 2, "rsp.rsptype = " + paramlvn.a + ", errCode = " + paramInt);
            }
            if ((paramlvn.a == 1) || (paramlvn.a == 2))
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
                paramlvn = (lvo)paramlvn;
                RandomController.a(this.a).a(paramlvn);
                RandomController.a(this.a).a().postDelayed(RandomController.a(this.a), paramlvn.h);
                return;
              case 0: 
                RandomController.a(this.a, paramlvn);
                return;
              case -1: 
                RandomController.a(this.a);
                return;
              }
              RandomController.b(this.a, paramlvn);
              return;
            }
            if ((paramlvn.a == -100) || (paramlvn.a == 3))
            {
              if (RandomController.a(this.a) == 1)
              {
                if ((paramInt == 0) && ((paramlvn instanceof lvp)))
                {
                  paramlvn = (lvp)paramlvn;
                  this.a.jdField_a_of_type_Lid.a.a = paramlvn.a;
                  if (this.a.jdField_a_of_type_Lid.k())
                  {
                    paramlvn = RandomController.a(this.a).iterator();
                    while (paramlvn.hasNext()) {
                      ((lvg)paramlvn.next()).a();
                    }
                  }
                }
              }
              else if (RandomController.a(this.a) == 2)
              {
                Object localObject2;
                Object localObject1;
                if ((paramInt == 0) && ((paramlvn instanceof lvr)))
                {
                  localObject2 = (lvr)paramlvn;
                  if (((lvr)localObject2).f != 0) {
                    if (((lvr)localObject2).f != 2) {
                      break label517;
                    }
                  }
                  for (localObject1 = ((lvr)localObject2).e;; localObject1 = String.valueOf(((lvr)localObject2).jdField_a_of_type_Long))
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      lfu locallfu = RandomController.a(this.a).a((String)localObject1);
                      if (locallfu != null)
                      {
                        locallfu.c = ((lvr)localObject2).c;
                        RandomController.a(this.a).a((String)localObject1, ((lvr)localObject2).b, ((lvr)localObject2).c);
                        if (QLog.isColorLevel()) {
                          QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + locallfu.jdField_a_of_type_Long + ", headUrl:" + locallfu.c);
                        }
                      }
                    }
                    localObject1 = RandomController.a(this.a).iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((lvg)((Iterator)localObject1).next()).a();
                    }
                  }
                }
                if (paramInt == 100)
                {
                  localObject2 = RandomController.a(this.a).c();
                  localObject1 = new StringBuilder();
                  localObject2 = ((ArrayList)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((StringBuilder)localObject1).append(((lfu)((Iterator)localObject2).next()).jdField_a_of_type_Long).append("|");
                  }
                  if ((!this.a.jdField_b_of_type_Boolean) && (RandomController.a(this.a) != null)) {
                    RandomController.a(this.a).a(RandomController.b(this.a), 5, ((StringBuilder)localObject1).toString(), this.a.a(RandomController.a(this.a).getAccount()), this.a.jdField_a_of_type_Long);
                  }
                }
                if ((paramlvn instanceof lvr))
                {
                  paramlvn = (lvr)paramlvn;
                  if ((!TextUtils.isEmpty(paramlvn.d)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_Lid.a.e)))
                  {
                    this.a.jdField_a_of_type_Lid.a.e = (RandomController.a(this.a).getApp().getString(2131696209) + " “" + paramlvn.d + "” ");
                    RandomController.a(this.a, paramlvn.d);
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.a.jdField_a_of_type_Lid.a.e);
                    }
                  }
                }
              }
              if (paramInt == -3)
              {
                paramlvn = RandomController.a(this.a).iterator();
                while (paramlvn.hasNext()) {
                  ((lvg)paramlvn.next()).a();
                }
              }
            }
            else
            {
              if ((!(paramlvn instanceof lvs)) || (paramlvn.a != 5)) {
                break label1010;
              }
              if (paramInt != 0) {
                break;
              }
              paramlvn = (lvs)paramlvn;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "request room owner room owner change push，uin " + paramlvn.b + " [random room owner]");
              }
              this.a.jdField_b_of_type_Int = 5;
              this.a.g = paramlvn.b;
              paramlvn = RandomController.a(this.a).iterator();
              while (paramlvn.hasNext()) {
                ((lvg)paramlvn.next()).a();
              }
            }
          }
        } while ((paramInt != -4) || (!QLog.isColorLevel()));
        QLog.e("RandomController", 2, "[random room owner] pull room fail fail");
        return;
      } while ((!(paramlvn instanceof lvs)) || (4 != paramlvn.a));
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] RSP_MULTI_KICK_MEMBER");
      }
      RandomController.a(this.a).a().removeCallbacks(RandomController.a(this.a));
      RandomController.a(this.a, false);
      paramlvn = (lvs)paramlvn;
      long l = paramlvn.jdField_a_of_type_OrgJsonJSONObject.optInt("groupid");
      this.a.jdField_a_of_type_JavaLangString = bdcv.a(paramlvn.jdField_a_of_type_OrgJsonJSONObject.optString("wording").trim());
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = RandomController.a(this.a).getApp().getApplicationContext().getString(2131696202);
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
          paramlvn = RandomController.a(this.a).iterator();
          while (paramlvn.hasNext()) {
            ((lvg)paramlvn.next()).a();
          }
          break;
          if (paramInt == -4)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RandomController", 2, "[random room owner] KICK_MEMBER fail" + paramlvn.jdField_a_of_type_JavaLangString);
            }
            this.a.jdField_b_of_type_Int = 7;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "KICK_MEMBER success groupid != mCurrGroupId  [random room owner]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lva
 * JD-Core Version:    0.7.0.1
 */