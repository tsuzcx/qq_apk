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

public class lst
  implements lta
{
  public lst(RandomController paramRandomController) {}
  
  public void a(int paramInt, ltg paramltg)
  {
    if (this.a.jdField_a_of_type_Lga == null) {}
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
              QLog.d("RandomController", 2, "rsp.rsptype = " + paramltg.a + ", errCode = " + paramInt);
            }
            if ((paramltg.a == 1) || (paramltg.a == 2))
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
                paramltg = (lth)paramltg;
                RandomController.a(this.a).a(paramltg);
                RandomController.a(this.a).a().postDelayed(RandomController.a(this.a), paramltg.h);
                return;
              case 0: 
                RandomController.a(this.a, paramltg);
                return;
              case -1: 
                RandomController.a(this.a);
                return;
              }
              RandomController.b(this.a, paramltg);
              return;
            }
            if ((paramltg.a == -100) || (paramltg.a == 3))
            {
              if (RandomController.a(this.a) == 1)
              {
                if ((paramInt == 0) && ((paramltg instanceof lti)))
                {
                  paramltg = (lti)paramltg;
                  this.a.jdField_a_of_type_Lga.a.a = paramltg.a;
                  if (this.a.jdField_a_of_type_Lga.j())
                  {
                    paramltg = RandomController.a(this.a).iterator();
                    while (paramltg.hasNext()) {
                      ((lsz)paramltg.next()).a();
                    }
                  }
                }
              }
              else if (RandomController.a(this.a) == 2)
              {
                Object localObject2;
                Object localObject1;
                if ((paramInt == 0) && ((paramltg instanceof ltk)))
                {
                  localObject2 = (ltk)paramltg;
                  if (((ltk)localObject2).f != 0) {
                    if (((ltk)localObject2).f != 2) {
                      break label517;
                    }
                  }
                  for (localObject1 = ((ltk)localObject2).e;; localObject1 = String.valueOf(((ltk)localObject2).jdField_a_of_type_Long))
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      ldr localldr = RandomController.a(this.a).a((String)localObject1);
                      if (localldr != null)
                      {
                        localldr.c = ((ltk)localObject2).c;
                        RandomController.a(this.a).a((String)localObject1, ((ltk)localObject2).b, ((ltk)localObject2).c);
                        if (QLog.isColorLevel()) {
                          QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + localldr.jdField_a_of_type_Long + ", headUrl:" + localldr.c);
                        }
                      }
                    }
                    localObject1 = RandomController.a(this.a).iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((lsz)((Iterator)localObject1).next()).a();
                    }
                  }
                }
                if (paramInt == 100)
                {
                  localObject2 = RandomController.a(this.a).c();
                  localObject1 = new StringBuilder();
                  localObject2 = ((ArrayList)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((StringBuilder)localObject1).append(((ldr)((Iterator)localObject2).next()).jdField_a_of_type_Long).append("|");
                  }
                  if ((!this.a.jdField_b_of_type_Boolean) && (RandomController.a(this.a) != null)) {
                    RandomController.a(this.a).a(RandomController.b(this.a), 5, ((StringBuilder)localObject1).toString(), this.a.a(RandomController.a(this.a).getAccount()), this.a.jdField_a_of_type_Long);
                  }
                }
                if ((paramltg instanceof ltk))
                {
                  paramltg = (ltk)paramltg;
                  if ((!TextUtils.isEmpty(paramltg.d)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_Lga.a.e)))
                  {
                    this.a.jdField_a_of_type_Lga.a.e = (RandomController.a(this.a).getApp().getString(2131696047) + " “" + paramltg.d + "” ");
                    RandomController.a(this.a, paramltg.d);
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.a.jdField_a_of_type_Lga.a.e);
                    }
                  }
                }
              }
              if (paramInt == -3)
              {
                paramltg = RandomController.a(this.a).iterator();
                while (paramltg.hasNext()) {
                  ((lsz)paramltg.next()).a();
                }
              }
            }
            else
            {
              if ((!(paramltg instanceof ltl)) || (paramltg.a != 5)) {
                break label1010;
              }
              if (paramInt != 0) {
                break;
              }
              paramltg = (ltl)paramltg;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "request room owner room owner change push，uin " + paramltg.b + " [random room owner]");
              }
              this.a.jdField_b_of_type_Int = 5;
              this.a.g = paramltg.b;
              paramltg = RandomController.a(this.a).iterator();
              while (paramltg.hasNext()) {
                ((lsz)paramltg.next()).a();
              }
            }
          }
        } while ((paramInt != -4) || (!QLog.isColorLevel()));
        QLog.e("RandomController", 2, "[random room owner] pull room fail fail");
        return;
      } while ((!(paramltg instanceof ltl)) || (4 != paramltg.a));
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] RSP_MULTI_KICK_MEMBER");
      }
      RandomController.a(this.a).a().removeCallbacks(RandomController.a(this.a));
      RandomController.a(this.a, false);
      paramltg = (ltl)paramltg;
      long l = paramltg.jdField_a_of_type_OrgJsonJSONObject.optInt("groupid");
      this.a.jdField_a_of_type_JavaLangString = bbea.a(paramltg.jdField_a_of_type_OrgJsonJSONObject.optString("wording").trim());
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = RandomController.a(this.a).getApp().getApplicationContext().getString(2131696040);
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
          paramltg = RandomController.a(this.a).iterator();
          while (paramltg.hasNext()) {
            ((lsz)paramltg.next()).a();
          }
          break;
          if (paramInt == -4)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RandomController", 2, "[random room owner] KICK_MEMBER fail" + paramltg.jdField_a_of_type_JavaLangString);
            }
            this.a.jdField_b_of_type_Int = 7;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "KICK_MEMBER success groupid != mCurrGroupId  [random room owner]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lst
 * JD-Core Version:    0.7.0.1
 */