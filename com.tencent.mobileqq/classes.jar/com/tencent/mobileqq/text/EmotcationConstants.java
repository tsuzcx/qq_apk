package com.tencent.mobileqq.text;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqemoticon.api.IAppleEmojiManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmotcationConstants
{
  public static final Map<String, Integer> DOUBLE_EMOJI_MAP;
  public static int[] EMOJI_CODES;
  public static String[] EMOJI_CONTENT_DESC;
  public static final SparseIntArray EMOJI_MAP;
  public static final int[] EMOTION_POS_ARRAY = { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 67, 69, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142 };
  public static final int FIRST_EMOJI_RES;
  public static final int FIRST_SYS_EMOTCATION_RES = 2130837760;
  public static final String IDX = "faceIdx";
  public static final int INDEX_OFFSET = 1000;
  static final int INVALID_EMOJ_RES;
  public static String[] IN_APK_SYS_GIF = { "f001", "f004", "f005", "f009", "f010", "f013", "f018", "f019", "f020", "f025", "f037", "f043", "f098", "f099", "f100", "f217", "f218", "f219" };
  public static final int[] LOCALE_TO_SERVER;
  public static final short[] LOCALE_TO_SERVER_OLD;
  public static int[] REPLACE_EMOJIS;
  public static final int[] SERVER_TO_LOCALE;
  public static final short[] SERVER_TO_LOCALE_OLD;
  public static final int[] STATIC_SYS_EMOTCATION_RESOURCE;
  public static final int[] STATIC_SYS_EMO_GIF_RES = { 2130837760, 2130837761, 2130837762, 2130837763, 2130837764, 2130837765, 2130837766, 2130837767, 2130837768, 2130837769, 2130837770, 2130837771, 2130837772, 2130837773, 2130837774, 2130837775, 2130837776, 2130837777, 2130837778, 2130837779, 2130837780, 2130837781, 2130837782, 2130837783, 2130837784, 2130837785, 2130837786, 2130837787, 2130837788, 2130837789, 2130837790, 2130837791, 2130837792, 2130837793, 2130837794, 2130837795, 2130837796, 2130837797, 2130837798, 2130837799, 2130837800, 2130837801, 2130837802, 2130837803, 2130837804, 2130837805, 2130837806, 2130837807, 2130837808, 2130837809, 2130837810, 2130837811, 2130837812, 2130837813, 2130837814, 2130837815, 2130837816, 2130837817, 2130837818, 2130837819, 2130838235, 2130837821, 2130837822, 2130837823, 2130837824, 2130837825, 2130837826, 2130837827, 2130837828, 2130837829, 2130837830, 2130837831, 2130837832, 2130838236, 2130837834, 2130837835, 2130837836, 2130837837, 2130837838, 2130837839, 2130837840, 2130837841, 2130837842, 2130837843, 2130837844, 2130837845, 2130837846, 2130837847, 2130837848, 2130837849, 2130837850, 2130837851, 2130837852, 2130837853, 2130838237, 2130837855, 2130837856, 2130837857, 2130837858, 2130837859, 2130837860, 2130837861, 2130837862, 2130837863, 2130837864, 2130837865, 2130837866, 2130837867, 2130837868, 2130837869, 2130837870, 2130837871, 2130837872, 2130837873, 2130837874, 2130837875, 2130837876, 2130837877, 2130837878, 2130837879, 2130837880, 2130837881, 2130837882, 2130837883, 2130837884, 2130837885, 2130837886, 2130837887, 2130837888, 2130837889, 2130837890, 2130837891, 2130837892, 2130837893, 2130837894, 2130837895, 2130837896, 2130837897, 2130837898, 2130837899, 2130837900, 2130837901, 2130837902, 2130839672, 2130839673, 2130839674, 2130839675, 2130839676, 2130839677, 2130839678, 2130839679, 2130839680, 2130839681, 2130839682, 2130839683, 2130839684, 2130839685, 2130839686, 2130839687, 2130839688, 2130839689, 2130839690, 2130839691, 2130839692, 2130839693, 2130839694, 2130839695, 2130839696, 2130839697, 2130839698, 2130839699, 2130839700, 2130839701, 2130839702, 2130839703, 2130839704, 2130839705, 2130839706, 2130839707, 2130839708, 2130839709, 2130839710, 2130839711, 2130839712, 2130839713, 2130839714, 2130839715, 2130839716, 2130839717, 2130839718, 2130839719, 2130839720, 2130839721, 2130839722, 2130839723, 2130839724, 2130839725, 2130839726, 2130839727, 2130839728, 2130839729, 2130839730, 2130839731, 2130839732, 2130839733, 2130839734, 2130839735, 2130839736, 2130839737, 2130839738, 2130839739, 2130839740, 2130839741, 2130839742, 2130839743, 2130839744, 2130839745, 2130839746, 2130839747, 2130839748 };
  public static final char SYS_EMOTCATION_HEAD = '\024';
  public static final char SYS_EMOTCATION_MODULO_OFFSET = 'A';
  public static final int SYS_EMOTCATION_MODULO_VALUE = 128;
  public static final String[] SYS_EMOTICON_SYMBOL;
  public static int VALID_EMOJI_COUNT;
  public static int VALID_SYS_EMOTCATION_COUNT;
  
  static
  {
    STATIC_SYS_EMOTCATION_RESOURCE = new int[] { 2130838784, 2130838785, 2130838786, 2130838787, 2130838788, 2130838789, 2130838790, 2130837767, 2130837768, 2130838793, 2130838794, 2130838795, 2130838796, 2130838797, 2130838798, 2130838799, 2130837776, 2130838801, 2130838802, 2130838803, 2130838804, 2130838805, 2130838806, 2130838807, 2130838808, 2130838809, 2130838810, 2130838811, 2130837788, 2130838813, 2130838814, 2130838815, 2130837792, 2130838817, 2130838818, 2130838819, 2130838820, 2130838821, 2130838822, 2130837799, 2130838824, 2130838825, 2130838826, 2130838827, 2130838828, 2130838829, 2130838830, 2130837807, 2130838832, 2130838833, 2130838834, 2130838835, 2130838836, 2130838837, 2130838838, 2130838839, 2130838840, 2130837817, 2130837818, 2130838843, 2130838235, 2130838845, 2130838846, 2130838847, 2130837824, 2130838849, 2130838850, 2130837827, 2130837828, 2130837829, 2130838854, 2130837831, 2130838856, 2130838240, 2130838858, 2130837835, 2130837836, 2130838239, 2130837838, 2130838863, 2130837840, 2130838865, 2130838866, 2130838867, 2130838868, 2130838869, 2130838870, 2130838871, 2130838872, 2130838873, 2130838874, 2130838875, 2130838876, 2130838877, 2130838241, 2130838879, 2130838880, 2130838881, 2130838882, 2130838883, 2130838884, 2130838885, 2130838886, 2130838887, 2130838888, 2130838889, 2130838890, 2130837867, 2130837868, 2130837869, 2130837870, 2130837871, 2130837872, 2130837873, 2130837874, 2130837875, 2130837876, 2130837877, 2130837878, 2130837879, 2130837880, 2130837881, 2130837882, 2130837883, 2130837884, 2130837885, 2130837886, 2130837887, 2130837888, 2130837889, 2130837890, 2130837891, 2130837892, 2130837893, 2130837894, 2130837895, 2130837896, 2130837897, 2130837898, 2130837899, 2130837900, 2130837901, 2130837902, 2130839750, 2130839751, 2130839752, 2130839753, 2130839754, 2130839755, 2130839756, 2130839757, 2130839758, 2130839759, 2130839760, 2130839761, 2130839762, 2130839763, 2130839764, 2130839765, 2130839766, 2130839767, 2130839768, 2130839769, 2130839770, 2130839771, 2130839772, 2130839773, 2130839774, 2130839775, 2130839776, 2130839777, 2130839778, 2130839779, 2130839780, 2130839781, 2130839782, 2130839783, 2130839784, 2130839785, 2130839786, 2130839787, 2130839788, 2130839789, 2130839790, 2130839791, 2130839792, 2130839793, 2130839794, 2130839795, 2130839796, 2130839797, 2130839798, 2130839799, 2130839800, 2130839801, 2130839802, 2130839803, 2130839804, 2130839805, 2130839806, 2130839807, 2130840055, 2130840056, 2130840057, 2130840058, 2130840059, 2130840060, 2130840061, 2130840062, 2130840063, 2130840064, 2130840065, 2130840066, 2130840067, 2130840068, 2130840069, 2130840070, 2130840071, 2130840072, 2130840073 };
    REPLACE_EMOJIS = new int[] { 133, 121, 142, 136, 131, 125, 122, 129, 139, 124, 111, 135, 115, 137, 134, 132, 138, 128, 113, 114, 126, 127, 107 };
    VALID_SYS_EMOTCATION_COUNT = STATIC_SYS_EMOTCATION_RESOURCE.length;
    SYS_EMOTICON_SYMBOL = new String[] { "/呲牙", "/调皮", "/流汗", "/偷笑", "/再见", "/敲打", "/擦汗", "/猪头", "/玫瑰", "/流泪", "/大哭", "/嘘...", "/酷", "/抓狂", "/委屈", "/便便", "/炸弹", "/菜刀", "/可爱", "/色", "/害羞", "/得意", "/吐", "/微笑", "/发怒", "/尴尬", "/惊恐", "/冷汗", "/爱心", "/示爱", "/白眼", "/傲慢", "/难过", "/惊讶", "/疑问", "/睡", "/亲亲", "/憨笑", "/爱情", "/衰", "/撇嘴", "/阴险", "/奋斗", "/发呆", "/右哼哼", "/拥抱", "/坏笑", "/飞吻", "/鄙视", "/晕", "/悠闲", "/可怜", "/赞", "/踩", "/握手", "/胜利", "/抱拳", "/凋谢", "/饭", "/蛋糕", "/西瓜", "/啤酒", "/瓢虫", "/勾引", "/OK", "/爱你", "/咖啡", "/钱", "/月亮", "/美女", "/刀", "/发抖", "/差劲", "/拳头", "/心碎", "/太阳", "/礼物", "/足球", "/骷髅", "/挥手", "/闪电", "/饥饿", "/困", "/咒骂", "/折磨", "/抠鼻", "/鼓掌", "/糗大了", "/左哼哼", "/哈欠", "/快哭了", "/吓", "/篮球", "/乒乓", "/NO", "/跳跳", "/怄火", "/转圈", "/磕头", "/回头", "/跳绳", "/激动", "/街舞", "/献吻", "/左太极", "/右太极", "/闭嘴", "/招财进宝", "/双喜", "/鞭炮", "/灯笼", "/发财", "/K歌", "/购物", "/邮件", "/帅", "/喝彩", "/祈祷", "/爆筋", "/棒棒糖", "/喝奶", "/下面", "/香蕉", "/飞机", "/开车", "/高铁左车头", "/车厢", "/高铁右车头", "/多云", "/下雨", "/钞票", "/熊猫", "/灯泡", "/风车", "/闹钟", "/打伞", "/彩球", "/钻戒", "/沙发", "/纸巾", "/药", "/手枪", "/青蛙", "/不开心", "/啊", "/惶恐", "/冷漠", "/呃", "/好棒", "/拜托", "/点赞", "/无聊", "/托脸", "/吃", "/送花", "/害怕", "/花痴", "/小样儿", "/脸红", "/飙泪", "/我不看", "/托腮", "/哇哦", "/茶", "/眨眼睛", "/泪奔", "/无奈", "/卖萌", "/小纠结", "/喷血", "/斜眼笑", "/doge", "/惊喜", "/骚扰", "/笑哭", "/我最美", "/河蟹", "/羊驼", "/栗子", "/幽灵", "/蛋", "/马赛克", "/菊花", "/肥皂", "/红包", "/大笑", "/啵啵", "/糊脸", "/拍头", "/扯一扯", "/舔一舔", "/蹭一蹭", "/拽炸天", "/顶呱呱", "/抱抱", "/暴击", "/开枪", "/撩一撩", "/拍桌", "/拍手", "/恭喜", "/干杯", "/嘲讽", "/哼", "/佛系", "/掐一掐", "/惊呆", "/颤抖", "/啃头", "/偷看", "/扇脸", "/原谅", "/喷脸", "/生日快乐", "/头撞击", "/甩头", "/扔狗", "/加油必胜", "/加油抱抱", "/口罩护体" };
    FIRST_EMOJI_RES = 2130839808;
    INVALID_EMOJ_RES = 2130839942;
    VALID_EMOJI_COUNT = 247;
    EMOJI_CODES = new int[] { 128522, 128524, 128538, 128531, 128560, 128541, 128513, 128540, 9786, 128521, 128525, 128532, 128516, 128527, 128530, 128563, 128536, 128557, 128561, 128514, 128170, 128074, 128077, 9757, 128079, 9996, 128078, 128591, 128076, 128072, 128073, 128070, 128071, 128064, 128067, 128068, 128066, 127834, 127837, 127836, 127833, 127847, 127843, 127874, 127838, 127828, 127859, 127839, 127866, 127867, 127864, 9749, 127822, 127818, 127827, 127817, 128138, 128684, 127876, 127801, 127881, 127796, 128157, 127872, 127880, 128026, 128141, 128163, 128081, 128276, 11088, 10024, 128168, 128166, 128293, 127942, 128176, 128164, 9889, 128099, 128169, 128137, 9832, 128235, 128273, 128274, 9992, 128644, 128663, 128676, 128690, 128014, 128640, 128652, 9973, 128105, 128104, 128103, 128102, 128053, 128025, 128055, 128128, 128036, 128040, 128046, 128020, 128056, 128123, 128027, 128032, 128054, 128047, 128124, 128039, 128051, 128045, 128082, 128087, 128132, 128096, 128098, 127746, 128092, 128089, 128085, 128095, 9729, 9728, 9748, 127769, 9924, 11093, 10060, 10068, 10069, 9742, 128247, 128241, 128224, 128187, 127909, 127908, 128299, 128191, 128147, 9827, 126980, 12349, 127920, 128677, 128679, 127928, 128136, 128704, 128701, 127968, 9962, 127974, 127973, 127976, 127975, 127978, 128697, 128698, 169, 174, 8482, 9786, 9888, 9917, 9925, 9978, 9989, 9994, 9995, 10052, 12951, 127383, 127804, 127808, 127812, 127815, 127820, 127821, 127824, 127846, 127853, 127868, 127918, 127923, 127925, 127929, 127931, 127934, 127936, 127946, 128009, 128013, 128044, 128126, 128127, 128148, 128162, 128175, 128552, 128201, 128205, 128222, 128512, 128545, 128515, 128516, 128517, 128518, 128519, 128520, 128522, 128523, 128525, 128526, 128528, 128529, 128531, 128533, 128535, 128537, 128539, 128542, 128543, 128544, 128547, 128548, 128550, 128551, 128553, 128554, 128555, 128556, 128558, 128559, 128562, 128565, 128566, 128567, 128534, 128549, 128546, 128114, 128115, 128110, 128119, 128130, 128118, 128116, 128117, 128113, 128120, 128570, 128568, 128571, 128573, 128572, 128576, 128575, 128569, 128574, 128121, 128122, 128584, 128585, 128586, 128125, 127775, 128171, 128165, 128167, 128069, 128075, 128080, 128588, 128694, 127939, 128131, 128107, 128106, 128108, 128109, 128143, 128145, 128111, 128582, 128581, 128129, 128587, 128134, 128135, 128133, 128112, 128590, 128589, 128583, 127913, 128094, 128097, 128084, 128090, 127933, 128086, 128088, 128188, 128093, 128091, 128083, 128155, 128153, 128156, 128154, 10084, 128151, 128149, 128150, 128158, 128152, 128140, 128139, 128142, 128100, 128101, 128172, 128173, 128058, 128049, 128057, 128048, 128059, 128061, 128023, 128018, 128052, 128017, 128024, 128060, 128038, 128037, 128035, 128034, 128029, 128028, 128030, 128012, 128031, 128011, 128004, 128015, 128000, 128003, 128005, 128007, 128016, 128019, 128021, 128022, 128001, 128002, 128050, 128033, 128010, 128043, 128042, 128006, 128008, 128041, 128062, 128144, 127800, 127799, 127803, 127802, 127809, 127811, 127810, 127807, 127806, 127797, 127794, 127795, 127792, 127793, 127760, 127774, 127773, 127770, 127761, 127762, 127763, 127764, 127765, 127766, 127767, 127768, 127772, 127771, 127757, 127758, 127759, 127755, 127756, 127776, 127744, 127745, 127752, 127754, 127885, 127886, 127890, 127891, 127887, 127878, 127879, 127888, 127889, 127875, 127877, 127873, 127883, 127882, 127884, 128302, 128249, 128252, 128192, 128189, 128190, 128223, 128225, 128250, 128251, 128266, 128265, 128264, 128263, 128277, 128226, 128227, 9203, 8987, 9200, 8986, 128275, 128271, 128272, 128270, 128161, 128294, 128262, 128261, 128268, 128267, 128269, 128705, 128703, 128295, 128297, 128296, 128682, 128298, 128180, 128181, 128183, 128182, 128179, 128184, 128242, 128231, 128229, 128228, 9993, 128233, 128232, 128239, 128234, 128236, 128237, 128238, 128230, 128221, 128196, 128195, 128209, 128202, 128220, 128203, 128197, 128198, 128199, 128193, 128194, 9986, 128204, 128206, 10002, 9999, 128207, 128208, 128213, 128215, 128216, 128217, 128211, 128212, 128210, 128218, 128214, 128278, 128219, 128300, 128301, 128240, 127911, 127932, 127926, 127930, 127927, 127183, 127924, 127922, 127919, 127944, 9918, 127921, 127945, 9971, 128693, 128692, 127937, 127943, 127935, 127938, 127940, 127907, 127861, 127862, 127865, 127863, 127860, 127829, 127831, 127830, 127835, 127844, 127857, 127845, 127832, 127858, 127842, 127841, 127849, 127854, 127848, 127856, 127850, 127851, 127852, 127855, 127823, 127819, 127826, 127825, 127816, 127840, 127814, 127813, 127805, 127969, 127979, 127970, 127971, 127977, 128146, 127980, 127972, 127751, 127750, 127983, 127984, 127981, 128508, 128510, 128507, 127748, 127749, 127747, 128509, 127753, 127904, 127905, 9970, 127906, 128674, 128675, 9875, 128186, 128641, 128642, 128650, 128649, 128670, 128646, 128645, 128648, 128647, 128669, 128651, 128643, 128654, 128653, 128665, 128664, 128661, 128662, 128667, 128666, 128680, 128660, 128656, 128673, 128671, 128672, 128668, 128655, 127915, 128678, 128304, 9981, 127982, 128511, 127914, 127917, 128681, 128287, 128290, 128291, 11014, 11015, 11013, 128288, 128289, 128292, 8599, 8598, 8600, 8601, 8596, 8597, 128260, 9664, 9654, 128316, 128317, 8617, 8618, 8505, 9194, 9193, 9195, 9196, 10549, 10548, 128256, 128257, 128258, 127381, 127385, 127378, 127379, 127382, 128246, 127910, 127489, 127535, 127539, 127541, 127540, 127538, 127568, 127545, 127546, 127542, 127514, 128699, 128700, 128702, 128688, 128686, 127359, 9855, 128685, 127543, 127544, 127490, 9410, 128706, 128708, 128709, 128707, 127569, 12953, 127377, 127384, 127380, 128683, 128286, 128245, 128687, 128689, 128691, 128695, 128696, 9940, 10035, 10055, 10062, 10036, 128159, 127386, 128243, 128244, 127344, 127345, 127374, 127358, 128160, 10175, 9851, 9800, 9801, 9802, 9803, 9804, 9805, 9806, 9807, 9808, 9809, 9810, 9811, 9934, 128303, 128185, 128178, 128177, 8252, 8265, 10071, 10067, 128285, 128282, 128281, 128283, 128284, 128359, 128336, 128348, 128337, 128349, 128338, 128350, 128339, 128351, 128340, 128352, 128341, 128342, 128343, 128344, 128345, 128346, 128353, 128354, 128355, 128356, 128357, 128358, 10006, 10133, 10134, 10135, 9824, 9829, 9830, 128174, 10004, 9745, 128280, 128279, 10160, 12336, 128305, 9724, 9723, 9726, 9725, 9642, 9643, 128314, 128306, 128307, 9899, 9898, 128308, 128309, 128315, 11036, 11035, 128310, 128311, 128312, 128313, 128657, 128658, 128659 };
    EMOJI_CONTENT_DESC = new String[] { "嘿嘿", "羞涩", "亲亲", "汗", "紧张", "吐舌", "呲牙", "淘气", "可爱", "媚眼", "花痴", "失落", "高兴", "哼哼", "不屑", "瞪眼", "飞吻", "大哭", "害怕", "激动", "肌肉", "拳头", "厉害", "向上", "鼓掌", "胜利", "鄙视", "合十", "好的", "向左", "向右", "向上", "向下", "眼睛", "鼻子", "嘴唇", "耳朵", "米饭", "意面", "拉面", "饭团", "刨冰", "寿司", "蛋糕", "面包", "汉堡", "煎蛋", "薯条", "啤酒", "干杯", "高脚杯", "咖啡", "苹果", "橙子", "草莓", "西瓜", "药丸", "吸烟", "圣诞树", "玫瑰", "庆祝", "椰子树", "礼物", "蝴蝶结", "气球", "海螺", "戒指", "炸弹", "皇冠", "铃铛", "星星", "闪光", "吹气", "水", "火", "奖杯", "钱", "睡觉", "闪电", "脚印", "便便", "打针", "热", "邮箱", "钥匙", "锁", "飞机", "列车", "汽车", "快艇", "自行车", "骑马", "火箭", "公交", "船", "妈妈", "爸爸", "女孩", "男孩", "猴", "章鱼", "猪", "骷髅", "小鸡", "树懒", "牛", "公鸡", "青蛙", "幽灵", "虫", "鱼", "狗", "老虎", "天使", "企鹅", "鲸鱼", "老鼠", "帽子", "连衣裙", "口红", "高跟鞋", "靴子", "雨伞", "包", "内衣", "衣服", "鞋子", "云朵", "晴天", "雨天", "月亮", "雪人", "正确", "错误", "问号", "叹号", "电话", "相机", "手机", "传真", "电脑", "摄影机", "话筒", "手枪", "光碟", "爱心", "扑克", "麻将", "股票", "老虎机", "信号灯", "路障", "吉他", "理发厅", "浴缸", "马桶", "家", "教堂", "银行", "医院", "酒店", "取款机", "便利店", "男性", "女性" };
    long l = SystemClock.uptimeMillis();
    EMOJI_MAP = new SparseIntArray(EMOJI_CODES.length);
    DOUBLE_EMOJI_MAP = new HashMap(300);
    int i = 0;
    while (i < VALID_EMOJI_COUNT)
    {
      int j = EMOJI_CODES[i];
      EMOJI_MAP.put(j, i);
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("old init cost:");
      localStringBuilder.append(SystemClock.uptimeMillis() - l);
      localStringBuilder.append("EMOJI_CODES.length=");
      localStringBuilder.append(EMOJI_CODES.length);
      QLog.d("AppleEmojiManager", 2, localStringBuilder.toString());
    }
    loadEmojiMapFormDisk();
    LOCALE_TO_SERVER = new int[] { 13, 12, 27, 20, 39, 38, 97, 46, 63, 5, 9, 33, 16, 18, 106, 59, 55, 112, 21, 2, 6, 4, 19, 14, 11, 10, 26, 96, 66, 116, 22, 23, 15, 0, 32, 8, 109, 28, 42, 36, 1, 108, 30, 3, 103, 49, 101, 85, 105, 34, 29, 111, 76, 77, 78, 79, 118, 64, 61, 53, 89, 113, 117, 119, 124, 122, 60, 50, 75, 81, 56, 41, 121, 120, 67, 74, 69, 57, 37, 129, 54, 24, 25, 31, 35, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 43, 86, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    SERVER_TO_LOCALE = new int[] { 33, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 23, 32, 12, -1, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, -1, 71, 38, 95, -1, -1, 7, -1, -1, 45, 67, -1, -1, 59, 80, 16, 70, 77, -1, 15, 66, 58, -1, 8, 57, -1, 28, 74, -1, 76, -1, -1, -1, -1, 75, 68, 52, 53, 54, 55, -1, 69, -1, -1, -1, 47, 96, -1, -1, 60, -1, -1, -1, -1, -1, -1, 27, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 61, 92, 93, 29, 62, 56, 63, 73, 72, 65, 94, 64, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142 };
    LOCALE_TO_SERVER_OLD = new short[] { 13, 12, 56, 73, 88, 87, 97, 59, 33, 5, 9, 82, 51, 53, 106, 72, 92, 112, 74, 2, 6, 4, 54, 14, 11, 10, 55, 96, 36, 116, 75, 76, 50, 0, 81, 8, 109, 57, 27, 85, 1, 108, 79, 3, 103, 62, 101, 21, 105, 83, 58, 111, 46, 47, 71, 95, 118, 34, 64, 38, 32, 113, 117, 119, 124, 122, 63, 89, 45, 16, 93, 25, 121, 120, 37, 42, 39, 29, 86, 129, 91, 77, 78, 80, 84, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 23, 26, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170 };
    SERVER_TO_LOCALE_OLD = new short[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 41, 20, 44, 22, 10, 21, 107, 36, 11, 26, 25, 2, 1, 24, 0, 70, 0, 0, 0, 0, 48, 0, 96, 0, 72, 97, 39, 0, 78, 0, 0, 61, 9, 58, 0, 29, 75, 60, 77, 0, 0, 76, 0, 0, 69, 53, 54, 0, 0, 33, 13, 0, 14, 23, 27, 3, 38, 51, 8, 0, 0, 46, 67, 59, 0, 0, 0, 0, 0, 0, 55, 16, 4, 19, 31, 32, 82, 83, 43, 84, 35, 12, 50, 85, 40, 79, 6, 5, 68, 0, 81, 17, 71, 0, 56, 28, 7, 86, 87, 88, 47, 89, 45, 90, 49, 15, 91, 42, 37, 92, 52, 18, 62, 93, 94, 30, 63, 57, 64, 74, 73, 66, 95, 65, 98, 99, 100, 101, 80, 102, 103, 104, 105, 106, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  }
  
  public static String afterXml(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject2 = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      int j = paramString1.length();
      if (paramString2 == null) {
        i = 0;
      } else {
        i = paramString2.length();
      }
      if (j < i + 15) {
        return paramString1;
      }
      Object localObject1 = new StringBuilder("\\[emoji:0x[a-fA-F0-9]{5}");
      Object localObject3 = new StringBuilder("\\[sysEmo:[0-9]{3}-[0-9]{3}");
      if (!TextUtils.isEmpty(paramString2))
      {
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject3).append(paramString2);
        j = paramString2.length();
      }
      else
      {
        j = 0;
      }
      ((StringBuilder)localObject1).append("\\]");
      ((StringBuilder)localObject3).append("\\]");
      localObject1 = Pattern.compile(((StringBuilder)localObject1).toString()).matcher(paramString1);
      localObject2 = new StringBuffer();
      paramString2 = null;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder(1024);
        paramString2.append("afterXml src:");
        paramString2.append(paramString1);
        paramString2.append(" start");
      }
      for (int i = 0; ((Matcher)localObject1).find(); i = 1)
      {
        i = Integer.valueOf(paramString1.substring(((Matcher)localObject1).start() + 9, ((Matcher)localObject1).end() - 1 - j), 16).intValue();
        if (i > 65535) {
          ((Matcher)localObject1).appendReplacement((StringBuffer)localObject2, new String(new int[] { i }, 0, 1));
        }
        if (QLog.isColorLevel())
        {
          paramString2.append("\n");
          paramString2.append("unicode");
          paramString2.append(":");
          paramString2.append(i);
        }
      }
      ((Matcher)localObject1).appendTail((StringBuffer)localObject2);
      localObject1 = localObject2;
      int k = i;
      if (paramBoolean)
      {
        localObject2 = ((StringBuffer)localObject2).toString();
        localObject3 = Pattern.compile(((StringBuilder)localObject3).toString()).matcher((CharSequence)localObject2);
        localObject1 = new StringBuffer();
        while (((Matcher)localObject3).find())
        {
          String[] arrayOfString = ((String)localObject2).substring(((Matcher)localObject3).start() + 8, ((Matcher)localObject3).end() - 1 - j).split("-");
          i = Integer.valueOf(arrayOfString[0], 10).intValue();
          k = Integer.valueOf(arrayOfString[1], 10).intValue();
          if (i != 92)
          {
            ((Matcher)localObject3).appendReplacement((StringBuffer)localObject1, new String(new char[] { '\024', (char)i }));
          }
          else
          {
            ((Matcher)localObject3).appendReplacement((StringBuffer)localObject1, new String(new char[] { '\024' }));
            ((StringBuffer)localObject1).append((char)i);
          }
          ((StringBuffer)localObject1).append((char)k);
          if (QLog.isColorLevel())
          {
            paramString2.append("\n");
            paramString2.append("sysEmo");
            paramString2.append(":");
            paramString2.append(i);
            paramString2.append("|");
            paramString2.append(k);
          }
          i = 1;
        }
        ((Matcher)localObject3).appendTail((StringBuffer)localObject1);
        k = i;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotcationConstants", 2, paramString2.toString());
      }
      localObject2 = paramString1;
      if (k != 0) {
        localObject2 = ((StringBuffer)localObject1).toString();
      }
    }
    return localObject2;
  }
  
  public static String beforXml(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (Character.codePointCount(paramString1, 0, paramString1.length()) == paramString1.length()) {
      if (!paramString1.contains(new String(new char[] { '\024' }))) {
        return paramString1;
      }
    }
    if (QLog.isColorLevel())
    {
      str1 = EmotcationConstants.class.getSimpleName();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("beforeXml:");
      localStringBuilder1.append(paramString1);
      QLog.i(str1, 2, localStringBuilder1.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder("[emoji:0x%05x");
    StringBuilder localStringBuilder2 = new StringBuilder("[sysEmo:%03d-%03d");
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder1.append(paramString2);
      localStringBuilder2.append(paramString2);
    }
    localStringBuilder1.append(']');
    localStringBuilder2.append(']');
    paramString2 = null;
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder(1024);
      paramString2.append("beforXml start");
    }
    int m = paramString1.length();
    int i = 0;
    for (String str1 = paramString1; i < m; str1 = paramString1)
    {
      int n = str1.codePointAt(i);
      String str2;
      int k;
      int j;
      if (n > 65535)
      {
        paramString1 = str1.substring(i, i + 2);
        str2 = String.format(localStringBuilder1.toString(), new Object[] { Integer.valueOf(n) });
        paramString1 = str1.replace(paramString1, str2);
        k = i + (str2.length() - 1);
        j = paramString1.length();
        if (QLog.isColorLevel())
        {
          paramString2.append("\n");
          paramString2.append("unicode");
          paramString2.append(":");
          paramString2.append(n);
        }
      }
      else
      {
        k = i;
        j = m;
        paramString1 = str1;
        if (n == 20)
        {
          n = i + 2;
          k = i;
          j = m;
          paramString1 = str1;
          if (n < m)
          {
            k = i;
            j = m;
            paramString1 = str1;
            if (paramBoolean)
            {
              m = str1.codePointAt(i + 1);
              n = str1.codePointAt(n);
              paramString1 = str1.substring(i, i + 3);
              str2 = String.format(localStringBuilder2.toString(), new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
              paramString1 = str1.replace(paramString1, str2);
              k = i + (str2.length() - 1);
              j = paramString1.length();
              if (QLog.isColorLevel())
              {
                paramString2.append("\n");
                paramString2.append("sysEmo");
                paramString2.append(":");
                paramString2.append(m);
                paramString2.append("|");
                paramString2.append(n);
              }
            }
          }
        }
      }
      i = k + 1;
      m = j;
    }
    if (QLog.isColorLevel()) {
      QLog.i("EmotcationConstants", 2, paramString2.toString());
    }
    return str1;
  }
  
  public static int getDoubleEmoji(int paramInt1, int paramInt2)
  {
    int j = -1;
    int i;
    if (((paramInt2 <= 127994) || (paramInt2 >= 128000)) && ((paramInt1 <= 127461) || (paramInt1 >= 127488)))
    {
      i = j;
      if (paramInt1 > 34)
      {
        i = j;
        if (paramInt1 >= 64) {}
      }
    }
    else
    {
      Object localObject = DOUBLE_EMOJI_MAP;
      if (localObject == null) {
        return -1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramInt2);
      localObject = (Integer)((Map)localObject).get(localStringBuilder.toString());
      i = j;
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      }
    }
    return i;
  }
  
  public static String getEmojiDesc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < EMOJI_CONTENT_DESC.length))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(EMOJI_CONTENT_DESC[paramInt]);
      localStringBuilder.append(" ");
      return localStringBuilder.toString();
    }
    return " 未知 ";
  }
  
  public static int getSingleEmoji(int paramInt)
  {
    int j = 0;
    int i;
    if ((paramInt > 8251) && (paramInt < 13056)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (paramInt > 126979) && (paramInt < 129473)) {
      if (paramInt > 127461)
      {
        i = j;
        if (paramInt < 127488) {}
      }
      else if ((paramInt > 41) && (paramInt < 64))
      {
        i = j;
      }
      else
      {
        i = 1;
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramInt > 65)
      {
        j = i;
        if (paramInt < 175) {
          j = 1;
        }
      }
    }
    if (j != 0) {
      return EMOJI_MAP.get(paramInt, -1);
    }
    return -1;
  }
  
  public static boolean isSkinEmoji(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private static void loadEmojiMapFormDisk()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject2 = new File(AppleEmojiManager.INDEX_FILE);
    File localFile = new File(AppleEmojiManager.EMOJI_FILE);
    Object localObject3 = BaseApplication.getContext();
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferencesName((Context)localObject3);
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((Context)localObject3).getPackageName());
      ((StringBuilder)localObject1).append("_preferences");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = ((Context)localObject3).getSharedPreferences((String)localObject1, 4);
    boolean bool = ((SharedPreferences)localObject1).getBoolean("build_emoji_file", false);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("loadEmojiMapFormDisk buildSuccess=");
      ((StringBuilder)localObject3).append(bool);
      QLog.d("AppleEmojiManager", 2, ((StringBuilder)localObject3).toString());
    }
    if ((bool) && (((File)localObject2).exists()) && (localFile.exists()))
    {
      setEmojiMap((File)localObject2, localFile);
    }
    else
    {
      localObject1 = ((SharedPreferences)localObject1).getString("apple_emoji_file", "");
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("loadEmojiMapFormDisk filepath=");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.d("AppleEmojiManager", 2, ((StringBuilder)localObject3).toString());
      }
      if ((localObject1 != null) && (!((String)localObject1).equals("")))
      {
        localObject3 = new File((String)localObject1);
        if (((File)localObject3).exists())
        {
          ThreadManager.post(new EmotcationConstants.1((File)localObject2, localFile, (File)localObject3), 5, null, false);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("zipfile path=");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("MF", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject1 = ((IAppleEmojiManager)QRoute.api(IAppleEmojiManager.class)).getAppleEmojiSpName();
          BaseApplication.getContext().getSharedPreferences((String)localObject1, 4).edit().clear().commit();
          DOUBLE_EMOJI_MAP.clear();
          reDownloadAppleEmoji();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppleEmojiManager", 2, "apple_emoji_file sp is null reload");
        }
        reDownloadAppleEmoji();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppleEmojiManager", 2, "emoji index file not exist,load fail");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppleEmojiManager", 2, new Object[] { "init full emoji index cost:", Long.valueOf(SystemClock.uptimeMillis() - l) });
    }
  }
  
  public static void reDownloadAppleEmoji()
  {
    ((IAppleEmojiManager)QRoute.api(IAppleEmojiManager.class)).reDownloadAppleEmoji();
  }
  
  /* Error */
  public static void setEmojiMap(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +410 -> 411
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +403 -> 411
    //   11: invokestatic 1929	android/os/SystemClock:uptimeMillis	()J
    //   14: lstore 5
    //   16: invokestatic 2386	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: astore 8
    //   21: getstatic 2391	android/os/Build$VERSION:SDK_INT	I
    //   24: bipush 24
    //   26: if_icmplt +13 -> 39
    //   29: aload 8
    //   31: invokestatic 2397	android/preference/PreferenceManager:getDefaultSharedPreferencesName	(Landroid/content/Context;)Ljava/lang/String;
    //   34: astore 7
    //   36: goto +39 -> 75
    //   39: new 1954	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 1956	java/lang/StringBuilder:<init>	()V
    //   46: astore 7
    //   48: aload 7
    //   50: aload 8
    //   52: invokevirtual 2402	android/content/Context:getPackageName	()Ljava/lang/String;
    //   55: invokevirtual 1962	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 7
    //   61: ldc_w 2404
    //   64: invokevirtual 1962	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 7
    //   70: invokevirtual 1976	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore 7
    //   75: aload 8
    //   77: aload 7
    //   79: iconst_4
    //   80: invokevirtual 2408	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   83: ldc_w 2410
    //   86: iconst_0
    //   87: invokeinterface 2416 3 0
    //   92: ifeq +318 -> 410
    //   95: aload_0
    //   96: invokevirtual 2424	java/io/File:exists	()Z
    //   99: ifeq +311 -> 410
    //   102: aload_1
    //   103: invokevirtual 2424	java/io/File:exists	()Z
    //   106: ifeq +304 -> 410
    //   109: aconst_null
    //   110: astore 7
    //   112: aconst_null
    //   113: astore_1
    //   114: getstatic 1942	com/tencent/mobileqq/text/EmotcationConstants:DOUBLE_EMOJI_MAP	Ljava/util/Map;
    //   117: invokeinterface 2483 1 0
    //   122: new 2505	java/io/BufferedInputStream
    //   125: dup
    //   126: new 2507	java/io/FileInputStream
    //   129: dup
    //   130: aload_0
    //   131: invokespecial 2510	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   134: invokespecial 2513	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   137: astore_0
    //   138: aload_0
    //   139: invokevirtual 2516	java/io/BufferedInputStream:read	()I
    //   142: istore_2
    //   143: iload_2
    //   144: iconst_m1
    //   145: if_icmpeq +109 -> 254
    //   148: iload_2
    //   149: iconst_1
    //   150: if_icmpne +28 -> 178
    //   153: aload_0
    //   154: invokestatic 2520	com/tencent/mobileqq/text/AppleEmojiManager:readIntFromStream	(Ljava/io/InputStream;)I
    //   157: istore_2
    //   158: aload_0
    //   159: invokestatic 2520	com/tencent/mobileqq/text/AppleEmojiManager:readIntFromStream	(Ljava/io/InputStream;)I
    //   162: istore_3
    //   163: getstatic 1937	com/tencent/mobileqq/text/EmotcationConstants:EMOJI_MAP	Landroid/util/SparseIntArray;
    //   166: iload_2
    //   167: iload_3
    //   168: sipush 1000
    //   171: iadd
    //   172: invokevirtual 1946	android/util/SparseIntArray:put	(II)V
    //   175: goto -37 -> 138
    //   178: aload_0
    //   179: invokestatic 2520	com/tencent/mobileqq/text/AppleEmojiManager:readIntFromStream	(Ljava/io/InputStream;)I
    //   182: istore_2
    //   183: aload_0
    //   184: invokestatic 2520	com/tencent/mobileqq/text/AppleEmojiManager:readIntFromStream	(Ljava/io/InputStream;)I
    //   187: istore_3
    //   188: aload_0
    //   189: invokestatic 2520	com/tencent/mobileqq/text/AppleEmojiManager:readIntFromStream	(Ljava/io/InputStream;)I
    //   192: istore 4
    //   194: getstatic 1942	com/tencent/mobileqq/text/EmotcationConstants:DOUBLE_EMOJI_MAP	Ljava/util/Map;
    //   197: astore_1
    //   198: new 1954	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 1956	java/lang/StringBuilder:<init>	()V
    //   205: astore 7
    //   207: aload 7
    //   209: iload_2
    //   210: invokevirtual 1970	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 7
    //   216: ldc_w 2299
    //   219: invokevirtual 1962	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 7
    //   225: iload_3
    //   226: invokevirtual 1970	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_1
    //   231: aload 7
    //   233: invokevirtual 1976	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: iload 4
    //   238: sipush 1000
    //   241: iadd
    //   242: invokestatic 2337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: invokeinterface 2523 3 0
    //   250: pop
    //   251: goto -113 -> 138
    //   254: aload_0
    //   255: invokevirtual 2526	java/io/BufferedInputStream:close	()V
    //   258: goto +59 -> 317
    //   261: astore_1
    //   262: goto +130 -> 392
    //   265: astore 7
    //   267: goto +20 -> 287
    //   270: astore 7
    //   272: aload_1
    //   273: astore_0
    //   274: aload 7
    //   276: astore_1
    //   277: goto +115 -> 392
    //   280: astore_1
    //   281: aload 7
    //   283: astore_0
    //   284: aload_1
    //   285: astore 7
    //   287: aload_0
    //   288: astore_1
    //   289: ldc_w 1972
    //   292: iconst_1
    //   293: ldc_w 2432
    //   296: aload 7
    //   298: invokestatic 2530	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload_0
    //   302: ifnull +15 -> 317
    //   305: aload_0
    //   306: invokevirtual 2526	java/io/BufferedInputStream:close	()V
    //   309: goto +8 -> 317
    //   312: astore_0
    //   313: aload_0
    //   314: invokevirtual 2533	java/io/IOException:printStackTrace	()V
    //   317: invokestatic 1952	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +90 -> 410
    //   323: ldc_w 1972
    //   326: iconst_2
    //   327: bipush 6
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: ldc_w 2535
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: invokestatic 1929	android/os/SystemClock:uptimeMillis	()J
    //   343: lload 5
    //   345: lsub
    //   346: invokestatic 2497	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   349: aastore
    //   350: dup
    //   351: iconst_2
    //   352: ldc_w 2537
    //   355: aastore
    //   356: dup
    //   357: iconst_3
    //   358: getstatic 1937	com/tencent/mobileqq/text/EmotcationConstants:EMOJI_MAP	Landroid/util/SparseIntArray;
    //   361: invokevirtual 2540	android/util/SparseIntArray:size	()I
    //   364: invokestatic 2337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: aastore
    //   368: dup
    //   369: iconst_4
    //   370: ldc_w 2542
    //   373: aastore
    //   374: dup
    //   375: iconst_5
    //   376: getstatic 1942	com/tencent/mobileqq/text/EmotcationConstants:DOUBLE_EMOJI_MAP	Ljava/util/Map;
    //   379: invokeinterface 2543 1 0
    //   384: invokestatic 2337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: aastore
    //   388: invokestatic 2500	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   391: return
    //   392: aload_0
    //   393: ifnull +15 -> 408
    //   396: aload_0
    //   397: invokevirtual 2526	java/io/BufferedInputStream:close	()V
    //   400: goto +8 -> 408
    //   403: astore_0
    //   404: aload_0
    //   405: invokevirtual 2533	java/io/IOException:printStackTrace	()V
    //   408: aload_1
    //   409: athrow
    //   410: return
    //   411: invokestatic 1952	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +13 -> 427
    //   417: ldc_w 1972
    //   420: iconst_2
    //   421: ldc_w 2545
    //   424: invokestatic 1980	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	paramFile1	File
    //   0	428	1	paramFile2	File
    //   142	68	2	i	int
    //   162	64	3	j	int
    //   192	50	4	k	int
    //   14	330	5	l	long
    //   34	198	7	localObject1	Object
    //   265	1	7	localIOException	java.io.IOException
    //   270	12	7	localObject2	Object
    //   285	12	7	localFile	File
    //   19	57	8	localBaseApplication	BaseApplication
    // Exception table:
    //   from	to	target	type
    //   138	143	261	finally
    //   153	175	261	finally
    //   178	251	261	finally
    //   138	143	265	java/io/IOException
    //   153	175	265	java/io/IOException
    //   178	251	265	java/io/IOException
    //   122	138	270	finally
    //   289	301	270	finally
    //   122	138	280	java/io/IOException
    //   254	258	312	java/io/IOException
    //   305	309	312	java/io/IOException
    //   396	400	403	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.EmotcationConstants
 * JD-Core Version:    0.7.0.1
 */