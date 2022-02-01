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

public class lsy
  implements ltf
{
  public lsy(RandomController paramRandomController) {}
  
  public void a(int paramInt, ltl paramltl)
  {
    if (this.a.jdField_a_of_type_Lff == null) {}
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
              QLog.d("RandomController", 2, "rsp.rsptype = " + paramltl.a + ", errCode = " + paramInt);
            }
            if ((paramltl.a == 1) || (paramltl.a == 2))
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
                paramltl = (ltm)paramltl;
                RandomController.a(this.a).a(paramltl);
                RandomController.a(this.a).a().postDelayed(RandomController.a(this.a), paramltl.h);
                return;
              case 0: 
                RandomController.a(this.a, paramltl);
                return;
              case -1: 
                RandomController.a(this.a);
                return;
              }
              RandomController.b(this.a, paramltl);
              return;
            }
            if ((paramltl.a == -100) || (paramltl.a == 3))
            {
              if (RandomController.a(this.a) == 1)
              {
                if ((paramInt == 0) && ((paramltl instanceof ltn)))
                {
                  paramltl = (ltn)paramltl;
                  this.a.jdField_a_of_type_Lff.a.a = paramltl.a;
                  if (this.a.jdField_a_of_type_Lff.l())
                  {
                    paramltl = RandomController.a(this.a).iterator();
                    while (paramltl.hasNext()) {
                      ((lte)paramltl.next()).a();
                    }
                  }
                }
              }
              else if (RandomController.a(this.a) == 2)
              {
                Object localObject2;
                Object localObject1;
                if ((paramInt == 0) && ((paramltl instanceof ltp)))
                {
                  localObject2 = (ltp)paramltl;
                  if (((ltp)localObject2).f != 0) {
                    if (((ltp)localObject2).f != 2) {
                      break label517;
                    }
                  }
                  for (localObject1 = ((ltp)localObject2).e;; localObject1 = String.valueOf(((ltp)localObject2).jdField_a_of_type_Long))
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      lcv locallcv = RandomController.a(this.a).a((String)localObject1);
                      if (locallcv != null)
                      {
                        locallcv.c = ((ltp)localObject2).c;
                        RandomController.a(this.a).a((String)localObject1, ((ltp)localObject2).b, ((ltp)localObject2).c);
                        if (QLog.isColorLevel()) {
                          QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + locallcv.jdField_a_of_type_Long + ", headUrl:" + locallcv.c);
                        }
                      }
                    }
                    localObject1 = RandomController.a(this.a).iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((lte)((Iterator)localObject1).next()).a();
                    }
                  }
                }
                if (paramInt == 100)
                {
                  localObject2 = RandomController.a(this.a).c();
                  localObject1 = new StringBuilder();
                  localObject2 = ((ArrayList)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((StringBuilder)localObject1).append(((lcv)((Iterator)localObject2).next()).jdField_a_of_type_Long).append("|");
                  }
                  if ((!this.a.jdField_b_of_type_Boolean) && (RandomController.a(this.a) != null)) {
                    RandomController.a(this.a).a(RandomController.b(this.a), 5, ((StringBuilder)localObject1).toString(), this.a.a(RandomController.a(this.a).getAccount()), this.a.jdField_a_of_type_Long);
                  }
                }
                if ((paramltl instanceof ltp))
                {
                  paramltl = (ltp)paramltl;
                  if ((!TextUtils.isEmpty(paramltl.d)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_Lff.a.e)))
                  {
                    this.a.jdField_a_of_type_Lff.a.e = (RandomController.a(this.a).getApp().getString(2131695134) + " “" + paramltl.d + "” ");
                    RandomController.a(this.a, paramltl.d);
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.a.jdField_a_of_type_Lff.a.e);
                    }
                  }
                }
              }
              if (paramInt == -3)
              {
                paramltl = RandomController.a(this.a).iterator();
                while (paramltl.hasNext()) {
                  ((lte)paramltl.next()).a();
                }
              }
            }
            else
            {
              if ((!(paramltl instanceof ltq)) || (paramltl.a != 5)) {
                break label1010;
              }
              if (paramInt != 0) {
                break;
              }
              paramltl = (ltq)paramltl;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "request room owner room owner change push，uin " + paramltl.b + " [random room owner]");
              }
              this.a.jdField_b_of_type_Int = 5;
              this.a.g = paramltl.b;
              paramltl = RandomController.a(this.a).iterator();
              while (paramltl.hasNext()) {
                ((lte)paramltl.next()).a();
              }
            }
          }
        } while ((paramInt != -4) || (!QLog.isColorLevel()));
        QLog.e("RandomController", 2, "[random room owner] pull room fail fail");
        return;
      } while ((!(paramltl instanceof ltq)) || (4 != paramltl.a));
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] RSP_MULTI_KICK_MEMBER");
      }
      RandomController.a(this.a).a().removeCallbacks(RandomController.a(this.a));
      RandomController.a(this.a, false);
      paramltl = (ltq)paramltl;
      long l = paramltl.jdField_a_of_type_OrgJsonJSONObject.optInt("groupid");
      this.a.jdField_a_of_type_JavaLangString = bhml.a(paramltl.jdField_a_of_type_OrgJsonJSONObject.optString("wording").trim());
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = RandomController.a(this.a).getApp().getApplicationContext().getString(2131695127);
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
          paramltl = RandomController.a(this.a).iterator();
          while (paramltl.hasNext()) {
            ((lte)paramltl.next()).a();
          }
          break;
          if (paramInt == -4)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RandomController", 2, "[random room owner] KICK_MEMBER fail" + paramltl.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     lsy
 * JD-Core Version:    0.7.0.1
 */