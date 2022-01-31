import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RandomListener;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.random.RandomWebProtocol.OnRequestListener;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class jkq
  implements RandomWebProtocol.OnRequestListener
{
  public jkq(RandomController paramRandomController) {}
  
  public void a(int paramInt, jlk paramjlk)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {}
    label517:
    label1014:
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
              QLog.d("RandomController", 2, "rsp.rsptype = " + paramjlk.a + ", errCode = " + paramInt);
            }
            if ((paramjlk.a == 1) || (paramjlk.a == 2))
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
                paramjlk = (jll)paramjlk;
                RandomController.a(this.a).a(paramjlk);
                RandomController.a(this.a).a().postDelayed(RandomController.a(this.a), paramjlk.h);
                return;
              case 0: 
                RandomController.a(this.a, paramjlk);
                return;
              case -1: 
                RandomController.a(this.a);
                return;
              }
              RandomController.b(this.a, paramjlk);
              return;
            }
            if ((paramjlk.a == -100) || (paramjlk.a == 3))
            {
              if (RandomController.a(this.a) == 1)
              {
                if ((paramInt == 0) && ((paramjlk instanceof jlm)))
                {
                  paramjlk = (jlm)paramjlk;
                  this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.a = paramjlk.a;
                  if (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.f())
                  {
                    paramjlk = RandomController.a(this.a).iterator();
                    while (paramjlk.hasNext()) {
                      ((RandomController.RandomListener)paramjlk.next()).a();
                    }
                  }
                }
              }
              else if (RandomController.a(this.a) == 2)
              {
                Object localObject2;
                Object localObject1;
                if ((paramInt == 0) && ((paramjlk instanceof jlo)))
                {
                  localObject2 = (jlo)paramjlk;
                  if (((jlo)localObject2).f != 0) {
                    if (((jlo)localObject2).f != 2) {
                      break label517;
                    }
                  }
                  for (localObject1 = ((jlo)localObject2).e;; localObject1 = String.valueOf(((jlo)localObject2).jdField_a_of_type_Long))
                  {
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      VideoController.GAudioFriends localGAudioFriends = RandomController.a(this.a).a((String)localObject1);
                      if (localGAudioFriends != null)
                      {
                        localGAudioFriends.c = ((jlo)localObject2).c;
                        RandomController.a(this.a).a((String)localObject1, ((jlo)localObject2).b, ((jlo)localObject2).c);
                        if (QLog.isColorLevel()) {
                          QLog.d("RandomController", 2, "RSP_MULTI_PULL uin:" + localGAudioFriends.jdField_a_of_type_Long + ", headUrl:" + localGAudioFriends.c);
                        }
                      }
                    }
                    localObject1 = RandomController.a(this.a).iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((RandomController.RandomListener)((Iterator)localObject1).next()).a();
                    }
                  }
                }
                if (paramInt == 100)
                {
                  localObject2 = RandomController.a(this.a).a();
                  localObject1 = new StringBuilder();
                  localObject2 = ((ArrayList)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext()) {
                    ((StringBuilder)localObject1).append(((VideoController.GAudioFriends)((Iterator)localObject2).next()).jdField_a_of_type_Long).append("|");
                  }
                  if ((!this.a.jdField_b_of_type_Boolean) && (RandomController.a(this.a) != null)) {
                    RandomController.a(this.a).a(RandomController.b(this.a), 5, ((StringBuilder)localObject1).toString(), this.a.a(RandomController.a(this.a).getAccount()), this.a.jdField_a_of_type_Long);
                  }
                }
                if ((paramjlk instanceof jlo))
                {
                  paramjlk = (jlo)paramjlk;
                  if ((!TextUtils.isEmpty(paramjlk.d)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.e)))
                  {
                    this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.e = (RandomController.a(this.a).getApp().getResources().getString(2131429344) + " “" + paramjlk.d + "” ");
                    RandomController.a(this.a, paramjlk.d);
                    if (QLog.isColorLevel()) {
                      QLog.d("RandomController", 2, "RSP_MULTI_PULL talkTips : " + this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.a.e);
                    }
                  }
                }
              }
              if (paramInt == -3)
              {
                paramjlk = RandomController.a(this.a).iterator();
                while (paramjlk.hasNext()) {
                  ((RandomController.RandomListener)paramjlk.next()).a();
                }
              }
            }
            else
            {
              if ((!(paramjlk instanceof jlp)) || (paramjlk.a != 5)) {
                break label1014;
              }
              if (paramInt != 0) {
                break;
              }
              paramjlk = (jlp)paramjlk;
              if (QLog.isColorLevel()) {
                QLog.d("RandomController", 2, "request room owner room owner change push，uin " + paramjlk.b + " [random room owner]");
              }
              this.a.jdField_b_of_type_Int = 5;
              this.a.g = paramjlk.b;
              paramjlk = RandomController.a(this.a).iterator();
              while (paramjlk.hasNext()) {
                ((RandomController.RandomListener)paramjlk.next()).a();
              }
            }
          }
        } while ((paramInt != -4) || (!QLog.isColorLevel()));
        QLog.e("RandomController", 2, "[random room owner] pull room fail fail");
        return;
      } while ((!(paramjlk instanceof jlp)) || (4 != paramjlk.a));
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "[random room owner] RSP_MULTI_KICK_MEMBER");
      }
      RandomController.a(this.a).a().removeCallbacks(RandomController.a(this.a));
      RandomController.a(this.a, false);
      paramjlk = (jlp)paramjlk;
      long l = paramjlk.jdField_a_of_type_OrgJsonJSONObject.optInt("groupid");
      this.a.jdField_a_of_type_JavaLangString = HexUtil.a(paramjlk.jdField_a_of_type_OrgJsonJSONObject.optString("wording").trim());
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = RandomController.a(this.a).getApp().getApplicationContext().getString(2131429317);
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
          paramjlk = RandomController.a(this.a).iterator();
          while (paramjlk.hasNext()) {
            ((RandomController.RandomListener)paramjlk.next()).a();
          }
          break;
          if (paramInt == -4)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RandomController", 2, "[random room owner] KICK_MEMBER fail" + paramjlk.jdField_a_of_type_JavaLangString);
            }
            this.a.jdField_b_of_type_Int = 7;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("RandomController", 2, "KICK_MEMBER success groupid != mCurrGroupId  [random room owner]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jkq
 * JD-Core Version:    0.7.0.1
 */