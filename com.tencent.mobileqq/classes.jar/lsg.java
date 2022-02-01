import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RequestFetchRunnable;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class lsg
  implements lsn
{
  public lsg(RandomController paramRandomController) {}
  
  public void a(int paramInt, lst paramlst)
  {
    if (this.a.jdField_a_of_type_Lez == null) {}
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
              QLog.d("RandomController", 2, "rsp.rsptype = " + paramlst.a + ", errCode = " + paramInt);
            }
            if ((paramlst.a == 1) || (paramlst.a == 2))
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
                paramlst = (lsu)paramlst;
                RandomController.a(this.a).a(paramlst);
                RandomController.a(this.a).a().postDelayed(RandomController.a(this.a), paramlst.h);
                return;
              case 0: 
                RandomController.a(this.a, paramlst);
                return;
              case -1: 
                RandomController.a(this.a);
                return;
              }
              RandomController.b(this.a, paramlst);
              return;
            }
            if ((paramlst.a == -100) || (paramlst.a == 3))
            {
              if (RandomController.a(this.a) == 1)
              {
                if ((paramInt == 0) && ((paramlst instanceof lsv)))
                {
                  paramlst = (lsv)paramlst;
                  this.a.jdField_a_of_type_Lez.a.a = paramlst.a;
                  if (this.a.jdField_a_of_type_Lez.l())
                  {
                    paramlst = RandomController.a(this.a).iterator();
                    while (paramlst.hasNext()) {
                      ((lsm)paramlst.next()).a();
                    }
                  }
                }
              }
              else if (RandomController.a(this.a) == 2)
              {
                Object localObject2;
                Object localObject1;
                if ((paramInt == 0) && ((paramlst instanceof lsx)))
                {
                  localObject2 = (lsx)paramlst;
                  if (((lsx)localObject2).f != 0) {
                    if (((lsx)localObject2).f != 2) {
                      break label517;
                    }
                  }
                  for (localObject1 = ((lsx)localObject2).e;; localObject1 = String.valueOf(((lsx)localObject2).jdField_a_of_type_Long))
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      lcp locallcp = RandomController.a(this.a).a((String)localObject1);
                      if (locallcp != null)
                      {
                        locallcp.c = ((lsx)localObject2).c;
                        RandomController.a(this.a).a((String)localObject1, ((lsx)localObject2).b, ((lsx)localObject2).c);
                        if (QLog.isColorLevel()) {
                          QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + locallcp.jdField_a_of_type_Long + ", headUrl:" + locallcp.c);
                        }
                      }
                    }
                    localObject1 = RandomController.a(this.a).iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((lsm)((Iterator)localObject1).next()).a();
                    }
                  }
                }
                if (paramInt == 100)
                {
                  localObject2 = RandomController.a(this.a).c();
                  localObject1 = new StringBuilder();
                  localObject2 = ((ArrayList)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((StringBuilder)localObject1).append(((lcp)((Iterator)localObject2).next()).jdField_a_of_type_Long).append("|");
                  }
                  if ((!this.a.jdField_b_of_type_Boolean) && (RandomController.a(this.a) != null)) {
                    RandomController.a(this.a).a(RandomController.b(this.a), 5, ((StringBuilder)localObject1).toString(), this.a.a(RandomController.a(this.a).getAccount()), this.a.jdField_a_of_type_Long);
                  }
                }
                if ((paramlst instanceof lsx))
                {
                  paramlst = (lsx)paramlst;
                  if ((!TextUtils.isEmpty(paramlst.d)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_Lez.a.e)))
                  {
                    this.a.jdField_a_of_type_Lez.a.e = (RandomController.a(this.a).getApp().getString(2131695273) + " “" + paramlst.d + "” ");
                    RandomController.a(this.a, paramlst.d);
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.a.jdField_a_of_type_Lez.a.e);
                    }
                  }
                }
              }
              if (paramInt == -3)
              {
                paramlst = RandomController.a(this.a).iterator();
                while (paramlst.hasNext()) {
                  ((lsm)paramlst.next()).a();
                }
              }
            }
            else
            {
              if ((!(paramlst instanceof lsy)) || (paramlst.a != 5)) {
                break label1010;
              }
              if (paramInt != 0) {
                break;
              }
              paramlst = (lsy)paramlst;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "request room owner room owner change push，uin " + paramlst.b + " [random room owner]");
              }
              this.a.jdField_b_of_type_Int = 5;
              this.a.g = paramlst.b;
              paramlst = RandomController.a(this.a).iterator();
              while (paramlst.hasNext()) {
                ((lsm)paramlst.next()).a();
              }
            }
          }
        } while ((paramInt != -4) || (!QLog.isColorLevel()));
        QLog.e("RandomController", 2, "[random room owner] pull room fail fail");
        return;
      } while ((!(paramlst instanceof lsy)) || (4 != paramlst.a));
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] RSP_MULTI_KICK_MEMBER");
      }
      RandomController.a(this.a).a().removeCallbacks(RandomController.a(this.a));
      RandomController.a(this.a, false);
      paramlst = (lsy)paramlst;
      long l = paramlst.jdField_a_of_type_OrgJsonJSONObject.optInt("groupid");
      this.a.jdField_a_of_type_JavaLangString = HexUtil.hexString2String(paramlst.jdField_a_of_type_OrgJsonJSONObject.optString("wording").trim());
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = RandomController.a(this.a).getApp().getApplicationContext().getString(2131695266);
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
          paramlst = RandomController.a(this.a).iterator();
          while (paramlst.hasNext()) {
            ((lsm)paramlst.next()).a();
          }
          break;
          if (paramInt == -4)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RandomController", 2, "[random room owner] KICK_MEMBER fail" + paramlst.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     lsg
 * JD-Core Version:    0.7.0.1
 */