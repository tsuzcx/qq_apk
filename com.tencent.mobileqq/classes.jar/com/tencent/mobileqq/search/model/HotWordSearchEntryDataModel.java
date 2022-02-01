package com.tencent.mobileqq.search.model;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
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
    int i;
    int j;
    label247:
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() != 0)
      {
        if (UniteSearchActivity.a == null) {
          break label247;
        }
        i = 0;
        if (i >= this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
          break label247;
        }
        if (TextUtils.equals(((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i)).title, UniteSearchActivity.a.title))
        {
          int k = 1;
          j = i;
          i = k;
          int m = j + paramInt;
          k = m;
          if (m > this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()) {
            k = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
          }
          ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.subList(j, k));
          j = localArrayList.size();
          k = 0;
          while ((k < this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() - 1) && (j < paramInt))
          {
            localArrayList.add(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(k));
            k += 1;
            j += 1;
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
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAppRuntime != null)
    {
      StringBuilder localStringBuilder;
      long l;
      if (!paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("search_discovery_sp_prefixlast_update_time");
        localStringBuilder.append(localAppRuntime.getAccount());
        localStringBuilder.append("_");
        localStringBuilder.append(paramInt);
        l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("search_discovery_sp_prefix_unifylast_update_time");
        localStringBuilder.append(localAppRuntime.getAccount());
        localStringBuilder.append("_");
        localStringBuilder.append(paramInt);
        l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      }
      bool1 = bool2;
      if (System.currentTimeMillis() - l > 86400000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public List<HotWordSearchEntryDataModel.HotSearchItem> a()
  {
    int i = this.jdField_b_of_type_Int;
    if (i <= 0) {
      i = 15;
    }
    return a(i);
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
    //   9: ifne +812 -> 821
    //   12: new 173	tencent/im/oidb/search/DynamicDiscovery$Result
    //   15: dup
    //   16: invokespecial 174	tencent/im/oidb/search/DynamicDiscovery$Result:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: aload_1
    //   24: invokevirtual 178	tencent/im/oidb/search/DynamicDiscovery$Result:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: pop
    //   28: aload 4
    //   30: getfield 182	tencent/im/oidb/search/DynamicDiscovery$Result:hot_search_gif_item	Ltencent/im/oidb/search/DynamicDiscovery$GifInfoItem;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +54 -> 89
    //   38: aload_0
    //   39: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   42: aload_1
    //   43: getfield 188	tencent/im/oidb/search/DynamicDiscovery$GifInfoItem:gif_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   46: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   49: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   52: putfield 201	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotSearchGifUrl	Ljava/lang/String;
    //   55: aload_0
    //   56: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   59: aload_1
    //   60: getfield 204	tencent/im/oidb/search/DynamicDiscovery$GifInfoItem:gif_url_night	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   63: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   66: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   69: putfield 207	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotSearchGifUrlNight	Ljava/lang/String;
    //   72: aload_0
    //   73: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   76: aload_1
    //   77: getfield 210	tencent/im/oidb/search/DynamicDiscovery$GifInfoItem:gif_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   80: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   83: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   86: putfield 213	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotSearchGifID	Ljava/lang/String;
    //   89: aload 4
    //   91: getfield 216	tencent/im/oidb/search/DynamicDiscovery$Result:hot_wrod_gif_item	Ltencent/im/oidb/search/DynamicDiscovery$GifInfoItem;
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +37 -> 133
    //   99: aload_0
    //   100: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   103: aload_1
    //   104: getfield 188	tencent/im/oidb/search/DynamicDiscovery$GifInfoItem:gif_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   107: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   110: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   113: putfield 219	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotWordGifUrl	Ljava/lang/String;
    //   116: aload_0
    //   117: getfield 45	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo;
    //   120: aload_1
    //   121: getfield 204	tencent/im/oidb/search/DynamicDiscovery$GifInfoItem:gif_url_night	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   124: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   127: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   130: putfield 222	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$GIFInfo:hotWordGifUrlNight	Ljava/lang/String;
    //   133: aload_0
    //   134: aload 4
    //   136: getfield 225	tencent/im/oidb/search/DynamicDiscovery$Result:result_ext	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   139: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   142: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   145: putfield 227	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   148: aload_0
    //   149: aload 4
    //   151: getfield 231	tencent/im/oidb/search/DynamicDiscovery$Result:frontend_word_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   154: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   157: putfield 161	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_b_of_type_Int	I
    //   160: aload 4
    //   162: getfield 239	tencent/im/oidb/search/DynamicDiscovery$Result:hot_search_items	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   165: invokevirtual 243	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   168: astore_1
    //   169: aload 4
    //   171: getfield 247	tencent/im/oidb/search/DynamicDiscovery$Result:title_header	Ltencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem;
    //   174: invokevirtual 252	tencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   177: checkcast 249	tencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem
    //   180: astore_3
    //   181: aload_0
    //   182: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   185: aload_3
    //   186: getfield 255	tencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem:icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   192: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   195: putfield 257	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:b	Ljava/lang/String;
    //   198: aload_0
    //   199: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   202: aload_3
    //   203: getfield 259	tencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   206: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   209: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   212: putfield 260	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   215: aload_0
    //   216: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   219: aload_3
    //   220: getfield 263	tencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem:morn_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   223: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   226: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   229: putfield 266	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:c	Ljava/lang/String;
    //   232: aload_0
    //   233: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   236: aload_3
    //   237: getfield 269	tencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem:morn_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   240: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   243: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   246: putfield 272	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:d	Ljava/lang/String;
    //   249: aload_0
    //   250: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   253: aload_3
    //   254: getfield 275	tencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem:header_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   257: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   260: putfield 276	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:jdField_a_of_type_Int	I
    //   263: aload_3
    //   264: getfield 279	tencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   267: invokevirtual 283	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   270: ifeq +20 -> 290
    //   273: aload_0
    //   274: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   277: aload_3
    //   278: getfield 279	tencent/im/oidb/search/DynamicDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
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
    //   313: ifne +497 -> 810
    //   316: aload_1
    //   317: invokeinterface 297 1 0
    //   322: astore 5
    //   324: aload 5
    //   326: invokeinterface 302 1 0
    //   331: ifeq +479 -> 810
    //   334: aload 5
    //   336: invokeinterface 306 1 0
    //   341: checkcast 308	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem
    //   344: astore 7
    //   346: aload 7
    //   348: getfield 311	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:item_ext	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   351: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   354: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   357: astore 8
    //   359: new 67	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem
    //   362: dup
    //   363: invokespecial 312	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:<init>	()V
    //   366: astore 6
    //   368: aload 6
    //   370: aload 7
    //   372: getfield 313	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   375: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   378: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   381: putfield 70	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   384: aload 6
    //   386: aload 4
    //   388: getfield 316	tencent/im/oidb/search/DynamicDiscovery$Result:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   391: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   394: putfield 318	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:type	I
    //   397: aload 6
    //   399: aload 7
    //   401: getfield 321	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:show_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   404: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   407: putfield 324	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showType	I
    //   410: aload 6
    //   412: aload 7
    //   414: getfield 327	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:wz_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   417: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   420: putfield 330	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showCount	I
    //   423: aload 6
    //   425: aload 8
    //   427: putfield 333	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:sExtInfo	Ljava/lang/String;
    //   430: aload 7
    //   432: getfield 336	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:recall_word	Lcom/tencent/mobileqq/pb/PBBytesField;
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
    //   467: getfield 346	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:img_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   470: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   473: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   476: putfield 349	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgUrl	Ljava/lang/String;
    //   479: aload 6
    //   481: aload 7
    //   483: getfield 352	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:detail_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   486: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   489: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   492: putfield 355	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:detailText	Ljava/lang/String;
    //   495: aload 6
    //   497: aload 7
    //   499: getfield 358	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   502: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   505: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   508: putfield 361	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:jumpUrl	Ljava/lang/String;
    //   511: aload 6
    //   513: aload 7
    //   515: getfield 364	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:mark_text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   518: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   521: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   524: putfield 367	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexTextColor	Ljava/lang/String;
    //   527: aload 6
    //   529: aload 7
    //   531: getfield 370	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:mark_bg_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   534: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   537: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   540: putfield 373	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexBgColor	Ljava/lang/String;
    //   543: aload 6
    //   545: aload 7
    //   547: getfield 376	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:img_bg_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   550: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   553: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   556: putfield 379	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgBgUrl	Ljava/lang/String;
    //   559: aload 6
    //   561: aload 7
    //   563: getfield 382	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   566: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   569: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   572: putfield 385	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:titleTextColor	Ljava/lang/String;
    //   575: aload 6
    //   577: aload 7
    //   579: getfield 388	tencent/im/oidb/search/DynamicDiscovery$HotSearchItem:right_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   582: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   585: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   588: putfield 391	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:rightIconUrl	Ljava/lang/String;
    //   591: aload 8
    //   593: invokevirtual 395	java/lang/String:isEmpty	()Z
    //   596: istore_2
    //   597: iload_2
    //   598: ifne +141 -> 739
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
    //   686: ifeq +14 -> 700
    //   689: aload 6
    //   691: ldc_w 431
    //   694: putfield 434	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:badgeUrl	Ljava/lang/String;
    //   697: goto +42 -> 739
    //   700: aload_1
    //   701: ldc_w 436
    //   704: invokestatic 76	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   707: ifeq +14 -> 721
    //   710: aload 6
    //   712: ldc_w 438
    //   715: putfield 434	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:badgeUrl	Ljava/lang/String;
    //   718: goto +21 -> 739
    //   721: aload_1
    //   722: ldc_w 440
    //   725: invokestatic 76	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   728: ifeq +11 -> 739
    //   731: aload 6
    //   733: ldc_w 442
    //   736: putfield 434	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:badgeUrl	Ljava/lang/String;
    //   739: getstatic 22	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   742: astore_1
    //   743: aload_1
    //   744: monitorenter
    //   745: aload_0
    //   746: getfield 33	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   749: aload 6
    //   751: invokevirtual 443	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   754: pop
    //   755: aload_1
    //   756: monitorexit
    //   757: goto -433 -> 324
    //   760: astore_3
    //   761: aload_1
    //   762: monitorexit
    //   763: aload_3
    //   764: athrow
    //   765: astore_1
    //   766: aload_3
    //   767: monitorexit
    //   768: aload_1
    //   769: athrow
    //   770: astore_1
    //   771: invokestatic 448	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   774: ifeq +36 -> 810
    //   777: new 121	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   784: astore_3
    //   785: aload_3
    //   786: ldc_w 450
    //   789: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: pop
    //   793: aload_3
    //   794: aload_1
    //   795: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: ldc_w 455
    //   802: iconst_2
    //   803: aload_3
    //   804: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 458	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: ldc_w 460
    //   813: iconst_2
    //   814: ldc_w 462
    //   817: invokestatic 464	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   820: return
    //   821: new 466	pb/unify/search/UnifySearchDiscovery$Result
    //   824: dup
    //   825: invokespecial 467	pb/unify/search/UnifySearchDiscovery$Result:<init>	()V
    //   828: astore 4
    //   830: aload 4
    //   832: aload_1
    //   833: invokevirtual 468	pb/unify/search/UnifySearchDiscovery$Result:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   836: pop
    //   837: aload 4
    //   839: getfield 469	pb/unify/search/UnifySearchDiscovery$Result:hot_search_items	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   842: invokevirtual 243	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   845: astore_1
    //   846: aload 4
    //   848: getfield 472	pb/unify/search/UnifySearchDiscovery$Result:title_header	Lpb/unify/search/UnifySearchDiscovery$TitleHeaderItem;
    //   851: invokevirtual 475	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   854: checkcast 474	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem
    //   857: astore_3
    //   858: aload_0
    //   859: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   862: aload_3
    //   863: getfield 476	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   866: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   869: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   872: putfield 257	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:b	Ljava/lang/String;
    //   875: aload_0
    //   876: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   879: aload_3
    //   880: getfield 477	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   883: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   886: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   889: putfield 260	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   892: aload_0
    //   893: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   896: aload_3
    //   897: getfield 478	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:morn_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   900: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   903: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   906: putfield 266	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:c	Ljava/lang/String;
    //   909: aload_0
    //   910: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   913: aload_3
    //   914: getfield 479	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:morn_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   917: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   920: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   923: putfield 272	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:d	Ljava/lang/String;
    //   926: aload_0
    //   927: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   930: aload_3
    //   931: getfield 480	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:header_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   934: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   937: putfield 276	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:jdField_a_of_type_Int	I
    //   940: aload_3
    //   941: getfield 481	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   944: invokevirtual 283	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   947: ifeq +20 -> 967
    //   950: aload_0
    //   951: getfield 40	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem	Lcom/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem;
    //   954: aload_3
    //   955: getfield 481	pb/unify/search/UnifySearchDiscovery$TitleHeaderItem:qq_index_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   958: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   961: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   964: putfield 286	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$TitleHeaderItem:e	Ljava/lang/String;
    //   967: aload_0
    //   968: getfield 33	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   971: invokevirtual 289	java/util/concurrent/CopyOnWriteArrayList:clear	()V
    //   974: aload_0
    //   975: getfield 291	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:d	I
    //   978: iconst_1
    //   979: invokestatic 293	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:a	(IZ)Z
    //   982: ifne +340 -> 1322
    //   985: aload_1
    //   986: invokeinterface 297 1 0
    //   991: astore 5
    //   993: aload 5
    //   995: invokeinterface 302 1 0
    //   1000: ifeq +322 -> 1322
    //   1003: aload 5
    //   1005: invokeinterface 306 1 0
    //   1010: checkcast 483	pb/unify/search/UnifySearchDiscovery$HotSearchItem
    //   1013: astore 7
    //   1015: new 67	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem
    //   1018: dup
    //   1019: invokespecial 312	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:<init>	()V
    //   1022: astore 6
    //   1024: aload 6
    //   1026: aload 7
    //   1028: getfield 484	pb/unify/search/UnifySearchDiscovery$HotSearchItem:title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1031: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1034: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1037: putfield 70	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   1040: aload 6
    //   1042: aload 4
    //   1044: getfield 485	pb/unify/search/UnifySearchDiscovery$Result:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1047: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1050: putfield 318	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:type	I
    //   1053: aload 6
    //   1055: aload 7
    //   1057: getfield 486	pb/unify/search/UnifySearchDiscovery$HotSearchItem:show_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1060: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1063: putfield 324	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showType	I
    //   1066: aload 6
    //   1068: aload 7
    //   1070: getfield 487	pb/unify/search/UnifySearchDiscovery$HotSearchItem:wz_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1073: invokevirtual 235	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1076: putfield 330	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:showCount	I
    //   1079: aload 6
    //   1081: aload 7
    //   1083: getfield 488	pb/unify/search/UnifySearchDiscovery$HotSearchItem:item_ext	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1086: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1089: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1092: putfield 333	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:sExtInfo	Ljava/lang/String;
    //   1095: aload 7
    //   1097: getfield 489	pb/unify/search/UnifySearchDiscovery$HotSearchItem:recall_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1100: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1103: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1106: astore_3
    //   1107: aload_3
    //   1108: astore_1
    //   1109: aload_3
    //   1110: invokestatic 340	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1113: ifeq +9 -> 1122
    //   1116: aload 6
    //   1118: getfield 70	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:title	Ljava/lang/String;
    //   1121: astore_1
    //   1122: aload 6
    //   1124: aload_1
    //   1125: putfield 343	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:recallWord	Ljava/lang/String;
    //   1128: aload 6
    //   1130: aload 7
    //   1132: getfield 490	pb/unify/search/UnifySearchDiscovery$HotSearchItem:img_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1135: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1138: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1141: putfield 349	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgUrl	Ljava/lang/String;
    //   1144: aload 6
    //   1146: aload 7
    //   1148: getfield 491	pb/unify/search/UnifySearchDiscovery$HotSearchItem:detail_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1151: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1154: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1157: putfield 355	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:detailText	Ljava/lang/String;
    //   1160: aload 6
    //   1162: aload 7
    //   1164: getfield 492	pb/unify/search/UnifySearchDiscovery$HotSearchItem:jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1167: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1170: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1173: putfield 361	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:jumpUrl	Ljava/lang/String;
    //   1176: aload 6
    //   1178: aload 7
    //   1180: getfield 493	pb/unify/search/UnifySearchDiscovery$HotSearchItem:mark_text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1183: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1186: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1189: putfield 367	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexTextColor	Ljava/lang/String;
    //   1192: aload 6
    //   1194: aload 7
    //   1196: getfield 494	pb/unify/search/UnifySearchDiscovery$HotSearchItem:mark_bg_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1199: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1202: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1205: putfield 373	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:indexBgColor	Ljava/lang/String;
    //   1208: aload 6
    //   1210: aload 7
    //   1212: getfield 495	pb/unify/search/UnifySearchDiscovery$HotSearchItem:img_bg_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1215: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1218: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1221: putfield 379	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:imgBgUrl	Ljava/lang/String;
    //   1224: aload 6
    //   1226: aload 7
    //   1228: getfield 496	pb/unify/search/UnifySearchDiscovery$HotSearchItem:text_color	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1231: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1234: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1237: putfield 385	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:titleTextColor	Ljava/lang/String;
    //   1240: aload 6
    //   1242: aload 7
    //   1244: getfield 497	pb/unify/search/UnifySearchDiscovery$HotSearchItem:right_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1247: invokevirtual 193	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1250: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1253: putfield 391	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel$HotSearchItem:rightIconUrl	Ljava/lang/String;
    //   1256: getstatic 22	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   1259: astore_1
    //   1260: aload_1
    //   1261: monitorenter
    //   1262: aload_0
    //   1263: getfield 33	com/tencent/mobileqq/search/model/HotWordSearchEntryDataModel:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   1266: aload 6
    //   1268: invokevirtual 443	java/util/concurrent/CopyOnWriteArrayList:add	(Ljava/lang/Object;)Z
    //   1271: pop
    //   1272: aload_1
    //   1273: monitorexit
    //   1274: goto -281 -> 993
    //   1277: astore_3
    //   1278: aload_1
    //   1279: monitorexit
    //   1280: aload_3
    //   1281: athrow
    //   1282: astore_1
    //   1283: invokestatic 448	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1286: ifeq +36 -> 1322
    //   1289: new 121	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1296: astore_3
    //   1297: aload_3
    //   1298: ldc_w 499
    //   1301: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: aload_3
    //   1306: aload_1
    //   1307: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1310: pop
    //   1311: ldc_w 455
    //   1314: iconst_2
    //   1315: aload_3
    //   1316: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1319: invokestatic 458	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1322: ldc_w 501
    //   1325: iconst_2
    //   1326: ldc_w 462
    //   1329: invokestatic 464	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1332: return
    //   1333: astore_1
    //   1334: goto -595 -> 739
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1337	0	this	HotWordSearchEntryDataModel
    //   596	2	2	bool	boolean
    //   180	265	3	localObject1	Object
    //   760	7	3	localObject2	Object
    //   784	326	3	localObject3	Object
    //   1277	4	3	localObject4	Object
    //   1296	20	3	localStringBuilder	StringBuilder
    //   19	1024	4	localObject5	Object
    //   322	682	5	localIterator	java.util.Iterator
    //   366	901	6	localHotSearchItem	HotWordSearchEntryDataModel.HotSearchItem
    //   344	899	7	localObject6	Object
    //   357	249	8	str	String
    // Exception table:
    //   from	to	target	type
    //   745	757	760	finally
    //   761	763	760	finally
    //   296	305	765	finally
    //   766	768	765	finally
    //   21	34	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   38	89	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   89	95	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   99	133	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   133	290	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   290	296	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   305	324	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   324	442	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   444	457	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   457	597	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   601	697	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   700	718	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   721	739	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   739	745	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   763	765	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   768	770	770	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1262	1274	1277	finally
    //   1278	1280	1277	finally
    //   830	967	1282	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   967	993	1282	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   993	1107	1282	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1109	1122	1282	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1122	1262	1282	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1280	1282	1282	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   601	697	1333	org/json/JSONException
    //   700	718	1333	org/json/JSONException
    //   721	739	1333	org/json/JSONException
  }
  
  public List<HotWordSearchEntryDataModel.HotSearchItem> b()
  {
    if (this.c == 1) {
      return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
    }
    return a(SearchEntryConfigManager.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */