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

public class lih
  implements lio
{
  public lih(RandomController paramRandomController) {}
  
  public void a(int paramInt, liu paramliu)
  {
    if (this.a.jdField_a_of_type_Kvq == null) {}
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
              QLog.d("RandomController", 2, "rsp.rsptype = " + paramliu.a + ", errCode = " + paramInt);
            }
            if ((paramliu.a == 1) || (paramliu.a == 2))
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
                paramliu = (liv)paramliu;
                RandomController.a(this.a).a(paramliu);
                RandomController.a(this.a).a().postDelayed(RandomController.a(this.a), paramliu.h);
                return;
              case 0: 
                RandomController.a(this.a, paramliu);
                return;
              case -1: 
                RandomController.a(this.a);
                return;
              }
              RandomController.b(this.a, paramliu);
              return;
            }
            if ((paramliu.a == -100) || (paramliu.a == 3))
            {
              if (RandomController.a(this.a) == 1)
              {
                if ((paramInt == 0) && ((paramliu instanceof liw)))
                {
                  paramliu = (liw)paramliu;
                  this.a.jdField_a_of_type_Kvq.a.a = paramliu.a;
                  if (this.a.jdField_a_of_type_Kvq.j())
                  {
                    paramliu = RandomController.a(this.a).iterator();
                    while (paramliu.hasNext()) {
                      ((lin)paramliu.next()).a();
                    }
                  }
                }
              }
              else if (RandomController.a(this.a) == 2)
              {
                Object localObject2;
                Object localObject1;
                if ((paramInt == 0) && ((paramliu instanceof liy)))
                {
                  localObject2 = (liy)paramliu;
                  if (((liy)localObject2).f != 0) {
                    if (((liy)localObject2).f != 2) {
                      break label517;
                    }
                  }
                  for (localObject1 = ((liy)localObject2).e;; localObject1 = String.valueOf(((liy)localObject2).jdField_a_of_type_Long))
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      kth localkth = RandomController.a(this.a).a((String)localObject1);
                      if (localkth != null)
                      {
                        localkth.c = ((liy)localObject2).c;
                        RandomController.a(this.a).a((String)localObject1, ((liy)localObject2).b, ((liy)localObject2).c);
                        if (QLog.isColorLevel()) {
                          QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + localkth.jdField_a_of_type_Long + ", headUrl:" + localkth.c);
                        }
                      }
                    }
                    localObject1 = RandomController.a(this.a).iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((lin)((Iterator)localObject1).next()).a();
                    }
                  }
                }
                if (paramInt == 100)
                {
                  localObject2 = RandomController.a(this.a).c();
                  localObject1 = new StringBuilder();
                  localObject2 = ((ArrayList)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((StringBuilder)localObject1).append(((kth)((Iterator)localObject2).next()).jdField_a_of_type_Long).append("|");
                  }
                  if ((!this.a.jdField_b_of_type_Boolean) && (RandomController.a(this.a) != null)) {
                    RandomController.a(this.a).a(RandomController.b(this.a), 5, ((StringBuilder)localObject1).toString(), this.a.a(RandomController.a(this.a).getAccount()), this.a.jdField_a_of_type_Long);
                  }
                }
                if ((paramliu instanceof liy))
                {
                  paramliu = (liy)paramliu;
                  if ((!TextUtils.isEmpty(paramliu.d)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_Kvq.a.e)))
                  {
                    this.a.jdField_a_of_type_Kvq.a.e = (RandomController.a(this.a).getApp().getString(2131630349) + " “" + paramliu.d + "” ");
                    RandomController.a(this.a, paramliu.d);
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.a.jdField_a_of_type_Kvq.a.e);
                    }
                  }
                }
              }
              if (paramInt == -3)
              {
                paramliu = RandomController.a(this.a).iterator();
                while (paramliu.hasNext()) {
                  ((lin)paramliu.next()).a();
                }
              }
            }
            else
            {
              if ((!(paramliu instanceof liz)) || (paramliu.a != 5)) {
                break label1010;
              }
              if (paramInt != 0) {
                break;
              }
              paramliu = (liz)paramliu;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "request room owner room owner change push，uin " + paramliu.b + " [random room owner]");
              }
              this.a.jdField_b_of_type_Int = 5;
              this.a.g = paramliu.b;
              paramliu = RandomController.a(this.a).iterator();
              while (paramliu.hasNext()) {
                ((lin)paramliu.next()).a();
              }
            }
          }
        } while ((paramInt != -4) || (!QLog.isColorLevel()));
        QLog.e("RandomController", 2, "[random room owner] pull room fail fail");
        return;
      } while ((!(paramliu instanceof liz)) || (4 != paramliu.a));
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] RSP_MULTI_KICK_MEMBER");
      }
      RandomController.a(this.a).a().removeCallbacks(RandomController.a(this.a));
      RandomController.a(this.a, false);
      paramliu = (liz)paramliu;
      long l = paramliu.jdField_a_of_type_OrgJsonJSONObject.optInt("groupid");
      this.a.jdField_a_of_type_JavaLangString = bach.a(paramliu.jdField_a_of_type_OrgJsonJSONObject.optString("wording").trim());
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = RandomController.a(this.a).getApp().getApplicationContext().getString(2131630342);
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
          paramliu = RandomController.a(this.a).iterator();
          while (paramliu.hasNext()) {
            ((lin)paramliu.next()).a();
          }
          break;
          if (paramInt == -4)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RandomController", 2, "[random room owner] KICK_MEMBER fail" + paramliu.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     lih
 * JD-Core Version:    0.7.0.1
 */