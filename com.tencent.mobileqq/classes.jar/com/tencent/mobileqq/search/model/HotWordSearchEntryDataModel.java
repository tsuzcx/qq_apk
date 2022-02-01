package com.tencent.mobileqq.search.model;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class HotWordSearchEntryDataModel
  extends SearchEntryDataModel
{
  private static final Object b;
  public final int a;
  public final HotWordSearchEntryDataModel.GIFInfo a;
  public final HotWordSearchEntryDataModel.TitleHeaderItem a;
  public String a;
  public final CopyOnWriteArrayList<HotWordSearchEntryDataModel.HotSearchItem> a;
  public int b;
  
  static
  {
    jdField_b_of_type_JavaLangObject = new Object();
  }
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_Int = 15;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem = new HotWordSearchEntryDataModel.TitleHeaderItem(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo = new HotWordSearchEntryDataModel.GIFInfo();
  }
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2, paramBoolean);
    this.jdField_a_of_type_Int = 15;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem = new HotWordSearchEntryDataModel.TitleHeaderItem(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo = new HotWordSearchEntryDataModel.GIFInfo();
    a(paramArrayOfByte);
  }
  
  private List<HotWordSearchEntryDataModel.HotSearchItem> a(int paramInt)
  {
    int m = 0;
    for (;;)
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)
        {
          if (UniteSearchActivity.a == null) {
            break label234;
          }
          i = 0;
          if (i >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
            break label234;
          }
          if (!TextUtils.equals(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).title, UniteSearchActivity.a.title)) {
            break label241;
          }
          int k = 1;
          j = i;
          i = k;
          k = j + paramInt;
          if (k > this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size())
          {
            k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
            ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.subList(j, k));
            j = localArrayList.size();
            k = m;
            if ((k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1) && (j < paramInt))
            {
              localArrayList.add(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k));
              k += 1;
              j += 1;
              continue;
            }
            if ((UniteSearchActivity.a != null) && (i == 0) && (localArrayList.size() > 0)) {
              localArrayList.set(0, UniteSearchActivity.a);
            }
            return localArrayList;
          }
        }
        else
        {
          return null;
        }
      }
      continue;
      label234:
      int i = 0;
      int j = 0;
      continue;
      label241:
      i += 1;
    }
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (localAppRuntime != null)
    {
      if (!paramBoolean) {}
      for (long l = localSharedPreferences.getLong("search_discovery_sp_prefixlast_update_time" + localAppRuntime.getAccount() + "_" + paramInt, 0L); System.currentTimeMillis() - l > 86400000L; l = localSharedPreferences.getLong("search_discovery_sp_prefix_unifylast_update_time" + localAppRuntime.getAccount() + "_" + paramInt, 0L)) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public List<HotWordSearchEntryDataModel.HotSearchItem> a()
  {
    if (this.jdField_b_of_type_Int > 0) {}
    for (int i = this.jdField_b_of_type_Int;; i = 15) {
      return a(i);
    }
  }
  
  /* Error */
  public void a(byte[] arg1)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 171	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_Boolean	Z
    //   9: ifne +806 -> 815
    //   12: new 173	pb/unite/search/DynamicDiscovery$Result
    //   15: dup
    //   16: invokespecial 174	pb/unite/search/DynamicDiscovery$Result:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: aload_1
    //   24: invokevirtual 178	pb/unite/search/DynamicDiscovery$Result:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: pop
    //   28: aload 4
    //   30: getfield 182	pb/unite/search/DynamicDiscovery$Result:hot_search_gif_item	Lpb/unite/search/DynamicDiscovery$GifInfoItem;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +54 -> 89
    //   38: aload_0
    //   39: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   42: aload_1
    //   43: getfield 188	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   46: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   49: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   52: putfield 201	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotSearchGifUrl	Ljava/lang/String;
    //   55: aload_0
    //   56: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   59: aload_1
    //   60: getfield 204	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_url_night	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   63: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   66: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   69: putfield 207	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotSearchGifUrlNight	Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   76: aload_1
    //   77: getfield 210	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   80: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   83: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   86: putfield 213	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotSearchGifID	Ljava/lang/String;
    //   89: aload 4
    //   91: getfield 216	pb/unite/search/DynamicDiscovery$Result:hot_wrod_gif_item	Lpb/unite/search/DynamicDiscovery$GifInfoItem;
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +37 -> 133
    //   99: aload_0
    //   100: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   103: aload_1
    //   104: getfield 188	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   107: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   110: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   113: putfield 219	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotWordGifUrl	Ljava/lang/String;
    //   116: aload_0
    //   117: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   120: aload_1
    //   121: getfield 204	pb/unite/search/DynamicDiscovery$GifInfoItem:gif_url_night	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   124: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   127: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   130: putfield 222	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotWordGifUrlNight	Ljava/lang/String;
    //   133: aload_0
    //   134: aload 4
    //   136: getfield 225	pb/unite/search/DynamicDiscovery$Result:result_ext	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   139: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   142: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   145: putfield 227	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   148: aload_0
    //   149: aload 4
    //   151: getfield 231	pb/unite/search/DynamicDiscovery$Result:frontend_word_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   154: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   157: putfield 161	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_b_of_type_Int	I
    //   160: aload 4
    //   162: getfield 239	pb/unite/search/DynamicDiscovery$Result:hot_search_items	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   165: invokevirtual 243	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   168: astore_1
    //   169: aload 4
    //   171: getfield 247	pb/unite/search/DynamicDiscovery$Result:title_header	Lpb/unite/search/DynamicDiscovery$TitleHeaderItem;
    //   174: invokevirtual 252	pb/unite/search/DynamicDiscovery$TitleHeaderItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   177: checkcast 249	pb/unite/search/DynamicDiscovery$TitleHeaderItem
    //   180: astore_3
    //   181: aload_0
    //   182: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   185: aload_3
    //   186: getfield 255	pb/unite/search/DynamicDiscovery$TitleHeaderItem:icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   192: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   195: putfield 257	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:b	Ljava/lang/String;
    //   198: aload_0
    //   199: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   202: aload_3
    //   203: getfield 259	pb/unite/search/DynamicDiscovery$TitleHeaderItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   206: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   209: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   212: putfield 260	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   215: aload_0
    //   216: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   219: aload_3
    //   220: getfield 263	pb/unite/search/DynamicDiscovery$TitleHeaderItem:morn_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   223: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   226: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   229: putfield 266	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:c	Ljava/lang/String;
    //   232: aload_0
    //   233: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   236: aload_3
    //   237: getfield 269	pb/unite/search/DynamicDiscovery$TitleHeaderItem:morn_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   240: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   243: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   246: putfield 272	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:d	Ljava/lang/String;
    //   249: aload_0
    //   250: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   253: aload_3
    //   254: getfield 275	pb/unite/search/DynamicDiscovery$TitleHeaderItem:header_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   257: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   260: putfield 276	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:jdField_a_of_type_Int	I
    //   263: aload_3
    //   264: getfield 279	pb/unite/search/DynamicDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   267: invokevirtual 283	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   270: ifeq +20 -> 290
    //   273: aload_0
    //   274: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   277: aload_3
    //   278: getfield 279	pb/unite/search/DynamicDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   281: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   284: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   287: putfield 286	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:e	Ljava/lang/String;
    //   290: getstatic 22	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   293: astore_3
    //   294: aload_3
    //   295: monitorenter
    //   296: aload_0
    //   297: getfield 33	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   300: invokevirtual 289	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   303: aload_3
    //   304: monitorexit
    //   305: aload_0
    //   306: getfield 291	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:d	I
    //   309: iconst_0
    //   310: invokestatic 293	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:a	(IZ)Z
    //   313: ifne +444 -> 757
    //   316: aload_1
    //   317: invokeinterface 297 1 0
    //   322: astore 5
    //   324: aload 5
    //   326: invokeinterface 302 1 0
    //   331: ifeq +426 -> 757
    //   334: aload 5
    //   336: invokeinterface 306 1 0
    //   341: checkcast 308	pb/unite/search/DynamicDiscovery$HotSearchItem
    //   344: astore 7
    //   346: aload 7
    //   348: getfield 311	pb/unite/search/DynamicDiscovery$HotSearchItem:item_ext	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   351: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   354: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   357: astore 8
    //   359: new 67	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem
    //   362: dup
    //   363: invokespecial 312	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:<init>	()V
    //   366: astore 6
    //   368: aload 6
    //   370: aload 7
    //   372: getfield 313	pb/unite/search/DynamicDiscovery$HotSearchItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   375: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   378: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   381: putfield 70	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   384: aload 6
    //   386: aload 4
    //   388: getfield 316	pb/unite/search/DynamicDiscovery$Result:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   391: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   394: putfield 318	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:type	I
    //   397: aload 6
    //   399: aload 7
    //   401: getfield 321	pb/unite/search/DynamicDiscovery$HotSearchItem:show_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   404: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   407: putfield 324	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showType	I
    //   410: aload 6
    //   412: aload 7
    //   414: getfield 327	pb/unite/search/DynamicDiscovery$HotSearchItem:wz_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   417: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   420: putfield 330	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showCount	I
    //   423: aload 6
    //   425: aload 8
    //   427: putfield 333	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:sExtInfo	Ljava/lang/String;
    //   430: aload 7
    //   432: getfield 336	pb/unite/search/DynamicDiscovery$HotSearchItem:recall_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   435: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   438: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   441: astore_3
    //   442: aload_3
    //   443: astore_1
    //   444: aload_3
    //   445: invokestatic 340	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   448: ifeq +9 -> 457
    //   451: aload 6
    //   453: getfield 70	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   456: astore_1
    //   457: aload 6
    //   459: aload_1
    //   460: putfield 343	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:recallWord	Ljava/lang/String;
    //   463: aload 6
    //   465: aload 7
    //   467: getfield 346	pb/unite/search/DynamicDiscovery$HotSearchItem:img_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   470: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   473: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   476: putfield 349	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgUrl	Ljava/lang/String;
    //   479: aload 6
    //   481: aload 7
    //   483: getfield 352	pb/unite/search/DynamicDiscovery$HotSearchItem:detail_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   486: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   489: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   492: putfield 355	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:detailText	Ljava/lang/String;
    //   495: aload 6
    //   497: aload 7
    //   499: getfield 358	pb/unite/search/DynamicDiscovery$HotSearchItem:jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   502: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   505: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   508: putfield 361	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:jumpUrl	Ljava/lang/String;
    //   511: aload 6
    //   513: aload 7
    //   515: getfield 364	pb/unite/search/DynamicDiscovery$HotSearchItem:mark_text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   518: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   521: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   524: putfield 367	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexTextColor	Ljava/lang/String;
    //   527: aload 6
    //   529: aload 7
    //   531: getfield 370	pb/unite/search/DynamicDiscovery$HotSearchItem:mark_bg_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   534: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   537: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   540: putfield 373	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexBgColor	Ljava/lang/String;
    //   543: aload 6
    //   545: aload 7
    //   547: getfield 376	pb/unite/search/DynamicDiscovery$HotSearchItem:img_bg_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   550: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   553: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   556: putfield 379	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgBgUrl	Ljava/lang/String;
    //   559: aload 6
    //   561: aload 7
    //   563: getfield 382	pb/unite/search/DynamicDiscovery$HotSearchItem:text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   566: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   569: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   572: putfield 385	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:titleTextColor	Ljava/lang/String;
    //   575: aload 6
    //   577: aload 7
    //   579: getfield 388	pb/unite/search/DynamicDiscovery$HotSearchItem:right_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   582: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   585: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   588: putfield 391	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:rightIconUrl	Ljava/lang/String;
    //   591: aload 8
    //   593: invokevirtual 395	java/lang/String:isEmpty	()Z
    //   596: istore_2
    //   597: iload_2
    //   598: ifne +99 -> 697
    //   601: new 397	org/json/JSONObject
    //   604: dup
    //   605: aload 8
    //   607: invokespecial 400	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   610: astore_1
    //   611: aload 6
    //   613: aload_1
    //   614: ldc_w 402
    //   617: invokevirtual 406	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   620: putfield 408	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:tagColor	Ljava/lang/String;
    //   623: aload 6
    //   625: aload_1
    //   626: ldc_w 410
    //   629: invokevirtual 406	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   632: putfield 412	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:tagInfo	Ljava/lang/String;
    //   635: aload 6
    //   637: aload_1
    //   638: ldc_w 414
    //   641: invokevirtual 406	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   644: putfield 416	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:tagBGColor	Ljava/lang/String;
    //   647: aload 6
    //   649: aload_1
    //   650: ldc_w 418
    //   653: invokevirtual 406	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   656: putfield 421	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:countText	Ljava/lang/String;
    //   659: aload 6
    //   661: aload_1
    //   662: ldc_w 423
    //   665: invokevirtual 406	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   668: putfield 425	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:sAppend	Ljava/lang/String;
    //   671: aload_1
    //   672: ldc_w 427
    //   675: invokevirtual 406	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   678: astore_1
    //   679: aload_1
    //   680: ldc_w 429
    //   683: invokestatic 76	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   686: ifeq +87 -> 773
    //   689: aload 6
    //   691: ldc_w 431
    //   694: putfield 434	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:badgeUrl	Ljava/lang/String;
    //   697: getstatic 22	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   700: astore_1
    //   701: aload_1
    //   702: monitorenter
    //   703: aload_0
    //   704: getfield 33	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   707: aload 6
    //   709: invokevirtual 435	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   712: pop
    //   713: aload_1
    //   714: monitorexit
    //   715: goto -391 -> 324
    //   718: astore_3
    //   719: aload_1
    //   720: monitorexit
    //   721: aload_3
    //   722: athrow
    //   723: astore_1
    //   724: invokestatic 440	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   727: ifeq +30 -> 757
    //   730: ldc_w 442
    //   733: iconst_2
    //   734: new 121	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   741: ldc_w 444
    //   744: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: aload_1
    //   748: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 450	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: ldc_w 452
    //   760: iconst_2
    //   761: ldc_w 454
    //   764: invokestatic 456	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   767: return
    //   768: astore_1
    //   769: aload_3
    //   770: monitorexit
    //   771: aload_1
    //   772: athrow
    //   773: aload_1
    //   774: ldc_w 458
    //   777: invokestatic 76	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   780: ifeq +14 -> 794
    //   783: aload 6
    //   785: ldc_w 460
    //   788: putfield 434	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:badgeUrl	Ljava/lang/String;
    //   791: goto -94 -> 697
    //   794: aload_1
    //   795: ldc_w 462
    //   798: invokestatic 76	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   801: ifeq -104 -> 697
    //   804: aload 6
    //   806: ldc_w 464
    //   809: putfield 434	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:badgeUrl	Ljava/lang/String;
    //   812: goto -115 -> 697
    //   815: new 466	pb/unify/search/UnifySearchDiscovery$Result
    //   818: dup
    //   819: invokespecial 467	pb/unify/search/UnifySearchDiscovery$Result:<init>	()V
    //   822: astore 4
    //   824: aload 4
    //   826: aload_1
    //   827: invokevirtual 468	pb/unify/search/UnifySearchDiscovery$Result:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   830: pop
    //   831: aload 4
    //   833: getfield 469	pb/unify/search/UnifySearchDiscovery$Result:hot_search_items	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   836: invokevirtual 243	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   839: astore_1
    //   840: aload 4
    //   842: getfield 472	pb/unify/search/UnifySearchDiscovery$Result:title_header	Lpb/unify/search/UnifySearchDiscovery$TitleHeaderItem;
    //   845: invokevirtual 475	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   848: checkcast 474	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem
    //   851: astore_3
    //   852: aload_0
    //   853: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   856: aload_3
    //   857: getfield 476	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   860: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   863: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   866: putfield 257	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:b	Ljava/lang/String;
    //   869: aload_0
    //   870: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   873: aload_3
    //   874: getfield 477	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   877: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   880: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   883: putfield 260	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   886: aload_0
    //   887: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   890: aload_3
    //   891: getfield 478	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:morn_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   894: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   897: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   900: putfield 266	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:c	Ljava/lang/String;
    //   903: aload_0
    //   904: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   907: aload_3
    //   908: getfield 479	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:morn_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   911: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   914: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   917: putfield 272	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:d	Ljava/lang/String;
    //   920: aload_0
    //   921: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   924: aload_3
    //   925: getfield 480	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:header_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   928: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   931: putfield 276	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:jdField_a_of_type_Int	I
    //   934: aload_3
    //   935: getfield 481	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   938: invokevirtual 283	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   941: ifeq +20 -> 961
    //   944: aload_0
    //   945: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   948: aload_3
    //   949: getfield 481	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   952: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   955: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   958: putfield 286	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:e	Ljava/lang/String;
    //   961: aload_0
    //   962: getfield 33	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   965: invokevirtual 289	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   968: aload_0
    //   969: getfield 291	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:d	I
    //   972: iconst_1
    //   973: invokestatic 293	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:a	(IZ)Z
    //   976: ifne +318 -> 1294
    //   979: aload_1
    //   980: invokeinterface 297 1 0
    //   985: astore 5
    //   987: aload 5
    //   989: invokeinterface 302 1 0
    //   994: ifeq +300 -> 1294
    //   997: aload 5
    //   999: invokeinterface 306 1 0
    //   1004: checkcast 483	pb/unify/search/UnifySearchDiscovery$HotSearchItem
    //   1007: astore 7
    //   1009: new 67	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem
    //   1012: dup
    //   1013: invokespecial 312	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:<init>	()V
    //   1016: astore 6
    //   1018: aload 6
    //   1020: aload 7
    //   1022: getfield 484	pb/unify/search/UnifySearchDiscovery$HotSearchItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1025: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1028: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1031: putfield 70	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   1034: aload 6
    //   1036: aload 4
    //   1038: getfield 485	pb/unify/search/UnifySearchDiscovery$Result:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1041: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1044: putfield 318	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:type	I
    //   1047: aload 6
    //   1049: aload 7
    //   1051: getfield 486	pb/unify/search/UnifySearchDiscovery$HotSearchItem:show_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1054: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1057: putfield 324	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showType	I
    //   1060: aload 6
    //   1062: aload 7
    //   1064: getfield 487	pb/unify/search/UnifySearchDiscovery$HotSearchItem:wz_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1067: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1070: putfield 330	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showCount	I
    //   1073: aload 7
    //   1075: getfield 488	pb/unify/search/UnifySearchDiscovery$HotSearchItem:recall_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1078: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1081: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1084: astore_3
    //   1085: aload_3
    //   1086: astore_1
    //   1087: aload_3
    //   1088: invokestatic 340	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1091: ifeq +9 -> 1100
    //   1094: aload 6
    //   1096: getfield 70	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   1099: astore_1
    //   1100: aload 6
    //   1102: aload_1
    //   1103: putfield 343	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:recallWord	Ljava/lang/String;
    //   1106: aload 6
    //   1108: aload 7
    //   1110: getfield 489	pb/unify/search/UnifySearchDiscovery$HotSearchItem:img_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1113: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1116: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1119: putfield 349	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgUrl	Ljava/lang/String;
    //   1122: aload 6
    //   1124: aload 7
    //   1126: getfield 490	pb/unify/search/UnifySearchDiscovery$HotSearchItem:detail_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1129: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1132: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1135: putfield 355	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:detailText	Ljava/lang/String;
    //   1138: aload 6
    //   1140: aload 7
    //   1142: getfield 491	pb/unify/search/UnifySearchDiscovery$HotSearchItem:jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1145: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1148: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1151: putfield 361	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:jumpUrl	Ljava/lang/String;
    //   1154: aload 6
    //   1156: aload 7
    //   1158: getfield 492	pb/unify/search/UnifySearchDiscovery$HotSearchItem:mark_text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1161: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1164: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1167: putfield 367	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexTextColor	Ljava/lang/String;
    //   1170: aload 6
    //   1172: aload 7
    //   1174: getfield 493	pb/unify/search/UnifySearchDiscovery$HotSearchItem:mark_bg_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1177: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1180: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1183: putfield 373	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexBgColor	Ljava/lang/String;
    //   1186: aload 6
    //   1188: aload 7
    //   1190: getfield 494	pb/unify/search/UnifySearchDiscovery$HotSearchItem:img_bg_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1193: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1196: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1199: putfield 379	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgBgUrl	Ljava/lang/String;
    //   1202: aload 6
    //   1204: aload 7
    //   1206: getfield 495	pb/unify/search/UnifySearchDiscovery$HotSearchItem:text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1209: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1212: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1215: putfield 385	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:titleTextColor	Ljava/lang/String;
    //   1218: aload 6
    //   1220: aload 7
    //   1222: getfield 496	pb/unify/search/UnifySearchDiscovery$HotSearchItem:right_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1225: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1228: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1231: putfield 391	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:rightIconUrl	Ljava/lang/String;
    //   1234: getstatic 22	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   1237: astore_1
    //   1238: aload_1
    //   1239: monitorenter
    //   1240: aload_0
    //   1241: getfield 33	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   1244: aload 6
    //   1246: invokevirtual 435	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   1249: pop
    //   1250: aload_1
    //   1251: monitorexit
    //   1252: goto -265 -> 987
    //   1255: astore_3
    //   1256: aload_1
    //   1257: monitorexit
    //   1258: aload_3
    //   1259: athrow
    //   1260: astore_1
    //   1261: invokestatic 440	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1264: ifeq +30 -> 1294
    //   1267: ldc_w 442
    //   1270: iconst_2
    //   1271: new 121	java/lang/StringBuilder
    //   1274: dup
    //   1275: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1278: ldc_w 498
    //   1281: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: aload_1
    //   1285: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1288: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1291: invokestatic 450	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1294: ldc_w 500
    //   1297: iconst_2
    //   1298: ldc_w 454
    //   1301: invokestatic 456	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1304: return
    //   1305: astore_1
    //   1306: goto -609 -> 697
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1309	0	this	HotWordSearchEntryDataModel
    //   596	2	2	bool	boolean
    //   180	265	3	localObject1	Object
    //   718	52	3	localObject2	Object
    //   851	237	3	localObject3	Object
    //   1255	4	3	localObject4	Object
    //   19	1018	4	localObject5	Object
    //   322	676	5	localIterator	java.util.Iterator
    //   366	879	6	localHotSearchItem	HotWordSearchEntryDataModel.HotSearchItem
    //   344	877	7	localObject6	Object
    //   357	249	8	str	String
    // Exception table:
    //   from	to	target	type
    //   703	715	718	finally
    //   719	721	718	finally
    //   21	34	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   38	89	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   89	95	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   99	133	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   133	290	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   290	296	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   305	324	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   324	442	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   444	457	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   457	597	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   601	697	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   697	703	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   721	723	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   771	773	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   773	791	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   794	812	723	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   296	305	768	finally
    //   769	771	768	finally
    //   1240	1252	1255	finally
    //   1256	1258	1255	finally
    //   824	961	1260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   961	987	1260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   987	1085	1260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1087	1100	1260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1100	1240	1260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1258	1260	1260	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   601	697	1305	org/json/JSONException
    //   773	791	1305	org/json/JSONException
    //   794	812	1305	org/json/JSONException
  }
  
  public List<HotWordSearchEntryDataModel.HotSearchItem> b()
  {
    if (this.c == 1) {
      return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    }
    return a(SearchEntryConfigManager.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */