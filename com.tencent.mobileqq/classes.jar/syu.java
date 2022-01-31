import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.HashSet;
import java.util.Set;

public class syu
  implements slx<tay, tch>
{
  public Set<String> a = new HashSet();
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    tay localtay = new tay();
    localtay.jdField_b_of_type_JavaLangString = paramString1;
    localtay.jdField_c_of_type_JavaLangString = paramString2;
    localtay.jdField_a_of_type_Boolean = paramBoolean;
    localtay.jdField_c_of_type_Int = paramInt;
    localtay.jdField_b_of_type_Long = paramLong;
    slv.a().a(localtay, this);
  }
  
  public void a(@NonNull tay paramtay, @Nullable tch paramtch, @NonNull ErrorMessage paramErrorMessage)
  {
    syv localsyv = new syv();
    localsyv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
    localsyv.jdField_a_of_type_JavaLangString = paramtay.jdField_b_of_type_JavaLangString;
    if (vjw.a(localsyv.jdField_a_of_type_JavaLangString)) {
      paramtay.jdField_c_of_type_JavaLangString = "4_10000";
    }
    localsyv.jdField_b_of_type_JavaLangString = paramtay.jdField_c_of_type_JavaLangString;
    localsyv.jdField_a_of_type_Boolean = paramtay.jdField_a_of_type_Boolean;
    sqd localsqd = (sqd)sqg.a(5);
    if ((paramtay.jdField_c_of_type_Int == 3) || (paramtay.jdField_c_of_type_Int == 4) || (paramtay.jdField_c_of_type_Int == 31) || (paramtay.jdField_c_of_type_Int == 62))
    {
      localsyv.jdField_a_of_type_Int = localsqd.a("Q.qqstory.player.WatchVideoHandler", paramtay.jdField_c_of_type_JavaLangString, paramtay.jdField_b_of_type_JavaLangString);
      StoryItem localStoryItem = localsqd.a(paramtay.jdField_c_of_type_JavaLangString, 1);
      if (localStoryItem != null)
      {
        if (localStoryItem.unReadCount == 0) {
          break label281;
        }
        localStoryItem.unReadCount = localsyv.jdField_a_of_type_Int;
        localsqd.a(paramtay.jdField_c_of_type_JavaLangString, 1, localStoryItem);
        urk.d("Q.qqstory.player.WatchVideoHandler", String.format("read video %s ,update %s unread count , count = %d", new Object[] { paramtay.jdField_b_of_type_JavaLangString, localStoryItem.key, Integer.valueOf(localStoryItem.unReadCount) }));
      }
      label210:
      if ((paramtch == null) || (!paramErrorMessage.isSuccess())) {
        break label294;
      }
      this.a.add(paramtay.jdField_b_of_type_JavaLangString);
      sgi.a().dispatch(localsyv);
    }
    label281:
    label294:
    do
    {
      return;
      localsyv.jdField_a_of_type_Int = localsqd.a(paramtay.jdField_c_of_type_JavaLangString);
      urk.a("Q.qqstory.player.WatchVideoHandler", "read video %s , source = %d , not effect recent story", paramtay.jdField_b_of_type_JavaLangString, Integer.valueOf(paramtay.jdField_c_of_type_Int));
      break;
      localsqd.a(paramtay.jdField_c_of_type_JavaLangString, 1);
      break label210;
      sgi.a().dispatch(localsyv);
      paramtch = localsqd.a(paramtay.jdField_b_of_type_JavaLangString);
    } while (paramtch == null);
    ((spw)sqg.a(13)).a(paramtay.jdField_b_of_type_JavaLangString, paramtay.jdField_c_of_type_JavaLangString, paramtay.jdField_a_of_type_Boolean, paramtch.mCreateTime, paramtay.jdField_c_of_type_Int, paramtay.d, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syu
 * JD-Core Version:    0.7.0.1
 */