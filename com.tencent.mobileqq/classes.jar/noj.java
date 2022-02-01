import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResponseBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItem;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ResultItemGroup;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public final class noj
  implements BusinessObserver
{
  public noj(Handler paramHandler) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        Object localObject = new mobileqq_dynamic_search.ResponseBody();
        for (;;)
        {
          try
          {
            ((mobileqq_dynamic_search.ResponseBody)localObject).mergeFrom(paramBundle);
            paramInt = ((mobileqq_dynamic_search.ResponseBody)localObject).retcode.get();
            if (paramInt != 0)
            {
              if (!QLog.isColorLevel()) {
                break label472;
              }
              QLog.d("lebasearch.SearchProtocol", 2, "retcode:" + paramInt);
              return;
            }
            if ((!((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.has()) || (!((mobileqq_dynamic_search.ResultItemGroup)((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.get(0)).result_items.has())) {
              break label472;
            }
            paramBundle = ((mobileqq_dynamic_search.ResultItemGroup)((mobileqq_dynamic_search.ResponseBody)localObject).item_groups.get(0)).result_items.get();
            localArrayList = new ArrayList();
            Iterator localIterator = paramBundle.iterator();
            if (!localIterator.hasNext()) {
              continue;
            }
            localResultItem = (mobileqq_dynamic_search.ResultItem)localIterator.next();
            localWordItem = new SearchProtocol.WordItem();
            if (!localResultItem.word.has()) {
              continue;
            }
            localWordItem.word = localResultItem.word.get().toStringUtf8();
            localWordItem.id = localResultItem.result_id.get().toStringUtf8();
            if (localResultItem.extension.has())
            {
              localObject = localResultItem.extension.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("lebasearch.SearchProtocol", 2, "extension info:" + (String)localObject);
              }
              paramBoolean = TextUtils.isEmpty((CharSequence)localObject);
              if (!paramBoolean) {
                paramBundle = null;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramBundle)
          {
            ArrayList localArrayList;
            mobileqq_dynamic_search.ResultItem localResultItem;
            SearchProtocol.WordItem localWordItem;
            if (!QLog.isColorLevel()) {
              break label472;
            }
            QLog.d("lebasearch.SearchProtocol", 2, paramBundle.getMessage());
            return;
            paramBundle = this.a.obtainMessage();
            paramBundle.arg1 = 0;
            paramBundle.obj = localArrayList;
            this.a.sendMessage(paramBundle);
          }
          try
          {
            localObject = new JSONObject((String)localObject);
            paramBundle = (Bundle)localObject;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            continue;
            paramInt = paramBundle.optInt("type");
          }
        }
        if (paramBundle == null)
        {
          paramInt = 0;
          if ((paramInt == 2) && (localResultItem.jmp_url.has()) && (!TextUtils.isEmpty(localResultItem.jmp_url.get().toStringUtf8())))
          {
            localWordItem.type = paramInt;
            localWordItem.jumpUrl = localResultItem.jmp_url.get().toStringUtf8();
            paramInt = SearchProtocol.a(paramBundle.optString("color"));
            if (paramInt == 0) {
              break label473;
            }
          }
        }
      }
    }
    for (;;)
    {
      localWordItem.textColor = paramInt;
      localWordItem.frameColor = SearchProtocol.a(paramBundle.optString("framecolor"));
      localArrayList.add(localWordItem);
      break;
      label472:
      return;
      label473:
      paramInt = -16734752;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     noj
 * JD-Core Version:    0.7.0.1
 */