import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.filter.FilterItem;
import com.tencent.biz.qqstory.model.filter.FilterItem.FilterItemIllegalException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFilterList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FilterListPack;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class teb
  extends syn
{
  @NonNull
  public final String a;
  @NonNull
  public final List<FilterItem> a;
  public final boolean a;
  public final int b;
  
  public teb(byte[] paramArrayOfByte)
  {
    Object localObject1 = new qqstory_service.RspGetFilterList();
    for (;;)
    {
      try
      {
        ((qqstory_service.RspGetFilterList)localObject1).mergeFrom(paramArrayOfByte);
        this.jdField_a_of_type_Int = ((qqstory_service.RspGetFilterList)localObject1).result.error_code.get();
        this.jdField_b_of_type_JavaLangString = ((qqstory_service.RspGetFilterList)localObject1).result.error_desc.get().toStringUtf8();
        if (((qqstory_service.RspGetFilterList)localObject1).is_end.get() != 0)
        {
          this.jdField_a_of_type_Boolean = bool;
          this.jdField_a_of_type_JavaLangString = ((qqstory_service.RspGetFilterList)localObject1).next_cookie.get().toStringUtf8();
          this.jdField_b_of_type_Int = ((qqstory_service.RspGetFilterList)localObject1).frequency.get();
          paramArrayOfByte = new ArrayList();
          localObject1 = ((qqstory_service.RspGetFilterList)localObject1).filter_list.get().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject2 = (qqstory_struct.FilterListPack)((Iterator)localObject1).next();
          tdt localtdt = new tdt();
          localtdt.jdField_a_of_type_Long = ((qqstory_struct.FilterListPack)localObject2).filter_id.get();
          localtdt.jdField_a_of_type_JavaLangString = ((qqstory_struct.FilterListPack)localObject2).filter_name.get().toStringUtf8();
          localtdt.jdField_a_of_type_Int = ((qqstory_struct.FilterListPack)localObject2).filter_type.get();
          localtdt.jdField_b_of_type_JavaLangString = ((qqstory_struct.FilterListPack)localObject2).filter_config_file.get().toStringUtf8();
          localtdt.c = ((qqstory_struct.FilterListPack)localObject2).filter_config_md5.get().toStringUtf8();
          try
          {
            localObject2 = localtdt.a();
            paramArrayOfByte.add(localObject2);
            ved.d("VideoFilterManager", "GET Filter : id=%d, name=%s, type=%d, url=%s, md5=%s", new Object[] { Long.valueOf(((FilterItem)localObject2).filterId), ((FilterItem)localObject2).filterName, Integer.valueOf(((FilterItem)localObject2).filterType), ((FilterItem)localObject2).filterConfigUrl, ((FilterItem)localObject2).filterConfigMd5 });
          }
          catch (FilterItem.FilterItemIllegalException localFilterItemIllegalException)
          {
            ved.c("VideoFilterManager", "GET Filter error : ", localFilterItemIllegalException);
          }
          continue;
        }
        bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ved.e("VideoFilterManager", "GetEmojiPackInfoListRequest error : " + paramArrayOfByte);
        this.jdField_a_of_type_Int = -1;
        this.jdField_b_of_type_JavaLangString = ajya.a(2131716272);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList = Collections.EMPTY_LIST;
        this.jdField_a_of_type_JavaLangString = "";
        this.jdField_b_of_type_Int = 0;
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     teb
 * JD-Core Version:    0.7.0.1
 */