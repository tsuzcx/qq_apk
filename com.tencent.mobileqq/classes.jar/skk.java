import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.Conversation;

public class skk
  implements Handler.Callback
{
  public skk(Conversation paramConversation) {}
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_1
    //   8: getfield 26	android/os/Message:what	I
    //   11: ldc 27
    //   13: if_icmpne +16 -> 29
    //   16: aload_0
    //   17: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   20: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   23: bipush 10
    //   25: iconst_0
    //   26: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   29: aload_1
    //   30: getfield 26	android/os/Message:what	I
    //   33: ldc 38
    //   35: if_icmpeq +18 -> 53
    //   38: aload_0
    //   39: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   42: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   48: ifne +5 -> 53
    //   51: iconst_1
    //   52: ireturn
    //   53: aload_1
    //   54: getfield 26	android/os/Message:what	I
    //   57: lookupswitch	default:+595->652, 1009:+606->663, 1010:+641->698, 1014:+2310->2367, 1016:+2320->2377, 1017:+2410->2467, 1019:+2741->2798, 1020:+2420->2477, 1023:+717->774, 1024:+2760->2817, 1025:+597->654, 1030:+2784->2841, 1032:+2202->2259, 1033:+2230->2287, 1035:+2891->2948, 1038:+2900->2957, 1039:+2928->2985, 1040:+2258->2315, 1041:+2284->2341, 1042:+3012->3069, 1044:+3041->3098, 1048:+3063->3120, 1049:+2956->3013, 1050:+2984->3041, 1051:+3140->3197, 1052:+3284->3341, 1053:+3329->3386, 1054:+3358->3415, 1055:+3436->3493, 10000:+2429->2486, 10001:+630->687, 10002:+630->687, 1134010:+1299->1356, 1134011:+1327->1384, 1134012:+2139->2196, 1134013:+2165->2222, 1134014:+2191->2248, 1134015:+2113->2170, 1134018:+865->922, 1134019:+1046->1103, 1134020:+1129->1186, 1134021:+2024->2081, 1134022:+2052->2109, 1134024:+2080->2137, 1134025:+2793->2850, 1134026:+2845->2902, 1134027:+1411->1468, 1134028:+1466->1523, 1134030:+3338->3395, 1134039:+1784->1841, 1134040:+1841->1898, 1134041:+1869->1926, 1134042:+1926->1983, 1134043:+1494->1551, 1134044:+1522->1579, 1134045:+1139->1196, 1134047:+1149->1206, 1134048:+1166->1223, 1134049:+1954->2011, 1134050:+1996->2053, 1134051:+1550->1607, 1134052:+1600->1657, 1134053:+1642->1699, 1134054:+1762->1819, 1134057:+1183->1240, 1134058:+1200->1257, 1134059:+1355->1412, 1134060:+1383->1440, 1134061:+3613->3670, 1134062:+3647->3704, 1134200:+3488->3545, 1134201:+3534->3591, 11340003:+734->791, 11340004:+1271->1328
    //   653: ireturn
    //   654: aload_0
    //   655: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   658: invokestatic 49	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   661: iconst_1
    //   662: ireturn
    //   663: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   666: ifeq +11 -> 677
    //   669: ldc 56
    //   671: iconst_2
    //   672: ldc 58
    //   674: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_0
    //   678: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   681: lconst_0
    //   682: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   685: iconst_1
    //   686: ireturn
    //   687: aload_0
    //   688: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   691: aload_1
    //   692: iconst_1
    //   693: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   696: iconst_1
    //   697: ireturn
    //   698: aload_0
    //   699: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   702: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   705: invokevirtual 70	com/tencent/mobileqq/activity/recent/BannerManager:a	()Z
    //   708: ifeq +38 -> 746
    //   711: aload_0
    //   712: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   715: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   718: bipush 17
    //   720: iconst_2
    //   721: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   724: aload_0
    //   725: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   728: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   731: bipush 17
    //   733: aload_1
    //   734: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   737: aload_0
    //   738: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   741: invokestatic 76	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   744: iconst_1
    //   745: ireturn
    //   746: aload_0
    //   747: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   750: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   753: bipush 17
    //   755: iconst_0
    //   756: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   759: aload_0
    //   760: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   763: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   766: bipush 17
    //   768: aconst_null
    //   769: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   772: iconst_1
    //   773: ireturn
    //   774: invokestatic 82	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   777: new 84	skl
    //   780: dup
    //   781: aload_0
    //   782: invokespecial 87	skl:<init>	(Lskk;)V
    //   785: invokevirtual 93	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   788: pop
    //   789: iconst_1
    //   790: ireturn
    //   791: invokestatic 98	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   794: invokevirtual 101	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   797: astore 10
    //   799: aload 10
    //   801: getfield 106	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   804: ifnull -753 -> 51
    //   807: aload_0
    //   808: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   811: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   814: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   817: astore 11
    //   819: aload 11
    //   821: ldc 112
    //   823: lconst_0
    //   824: invokeinterface 118 4 0
    //   829: lstore 5
    //   831: new 120	java/util/Date
    //   834: dup
    //   835: invokespecial 121	java/util/Date:<init>	()V
    //   838: invokevirtual 125	java/util/Date:getTime	()J
    //   841: lstore 7
    //   843: lload 7
    //   845: lload 5
    //   847: lsub
    //   848: aload 10
    //   850: getfield 106	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   853: getfield 131	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Lcom/tencent/mobileqq/app/NewUpgradeConfig$Dialog;
    //   856: getfield 135	com/tencent/mobileqq/app/NewUpgradeConfig$Dialog:b	I
    //   859: bipush 24
    //   861: imul
    //   862: bipush 60
    //   864: imul
    //   865: bipush 60
    //   867: imul
    //   868: sipush 1000
    //   871: imul
    //   872: i2l
    //   873: lcmp
    //   874: ifle -823 -> 51
    //   877: aload_0
    //   878: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   881: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   884: bipush 10
    //   886: iconst_2
    //   887: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   890: aload_0
    //   891: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   894: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   897: bipush 10
    //   899: aload_1
    //   900: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   903: aload 11
    //   905: invokeinterface 139 1 0
    //   910: ldc 112
    //   912: lload 7
    //   914: invokeinterface 145 4 0
    //   919: pop
    //   920: iconst_1
    //   921: ireturn
    //   922: invokestatic 98	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   925: invokevirtual 101	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper;
    //   928: astore 10
    //   930: aload 10
    //   932: getfield 106	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   935: ifnull -884 -> 51
    //   938: aload_0
    //   939: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   942: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   945: invokevirtual 110	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   948: astore 11
    //   950: aload 11
    //   952: ldc 112
    //   954: lconst_0
    //   955: invokeinterface 118 4 0
    //   960: lstore 5
    //   962: new 120	java/util/Date
    //   965: dup
    //   966: invokespecial 121	java/util/Date:<init>	()V
    //   969: invokevirtual 125	java/util/Date:getTime	()J
    //   972: lstore 7
    //   974: lload 7
    //   976: lload 5
    //   978: lsub
    //   979: aload 10
    //   981: getfield 106	com/tencent/mobileqq/app/upgrade/UpgradeDetailWrapper:a	Lcom/tencent/mobileqq/app/NewUpgradeConfig;
    //   984: getfield 131	com/tencent/mobileqq/app/NewUpgradeConfig:dialog	Lcom/tencent/mobileqq/app/NewUpgradeConfig$Dialog;
    //   987: getfield 135	com/tencent/mobileqq/app/NewUpgradeConfig$Dialog:b	I
    //   990: bipush 24
    //   992: imul
    //   993: bipush 60
    //   995: imul
    //   996: bipush 60
    //   998: imul
    //   999: sipush 1000
    //   1002: imul
    //   1003: i2l
    //   1004: lcmp
    //   1005: ifle +64 -> 1069
    //   1008: aload_0
    //   1009: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1012: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1015: bipush 12
    //   1017: iconst_2
    //   1018: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1021: aload_0
    //   1022: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1025: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1028: bipush 10
    //   1030: iconst_0
    //   1031: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1034: aload_0
    //   1035: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1038: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1041: bipush 12
    //   1043: aload_1
    //   1044: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1047: aload 11
    //   1049: invokeinterface 139 1 0
    //   1054: ldc 112
    //   1056: lload 7
    //   1058: invokeinterface 145 4 0
    //   1063: invokeinterface 148 1 0
    //   1068: pop
    //   1069: aload_1
    //   1070: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   1073: ifnull -1022 -> 51
    //   1076: aload_1
    //   1077: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   1080: instanceof 154
    //   1083: ifeq -1032 -> 51
    //   1086: aload_1
    //   1087: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   1090: checkcast 154	com/tencent/mobileqq/activity/UpgradeActivity
    //   1093: astore_1
    //   1094: invokestatic 98	com/tencent/mobileqq/app/upgrade/UpgradeController:a	()Lcom/tencent/mobileqq/app/upgrade/UpgradeController;
    //   1097: aload_1
    //   1098: invokevirtual 157	com/tencent/mobileqq/app/upgrade/UpgradeController:a	(Landroid/content/Context;)V
    //   1101: iconst_1
    //   1102: ireturn
    //   1103: aload_0
    //   1104: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1107: invokestatic 160	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1110: ifnull +22 -> 1132
    //   1113: aload_0
    //   1114: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1117: invokestatic 160	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1120: invokevirtual 165	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   1123: aload_0
    //   1124: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1127: aconst_null
    //   1128: invokestatic 168	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1131: pop
    //   1132: aload_0
    //   1133: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1136: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1139: bipush 12
    //   1141: iconst_0
    //   1142: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1145: aload_0
    //   1146: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1149: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1152: bipush 12
    //   1154: aload_1
    //   1155: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1158: iconst_1
    //   1159: ireturn
    //   1160: astore 10
    //   1162: aload_0
    //   1163: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1166: aconst_null
    //   1167: invokestatic 168	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1170: pop
    //   1171: goto -39 -> 1132
    //   1174: astore_1
    //   1175: aload_0
    //   1176: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1179: aconst_null
    //   1180: invokestatic 168	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   1183: pop
    //   1184: aload_1
    //   1185: athrow
    //   1186: aload_0
    //   1187: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1190: aload_1
    //   1191: invokestatic 171	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1194: iconst_1
    //   1195: ireturn
    //   1196: aload_0
    //   1197: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1200: aload_1
    //   1201: invokestatic 173	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1204: iconst_1
    //   1205: ireturn
    //   1206: invokestatic 82	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1209: new 175	skn
    //   1212: dup
    //   1213: aload_0
    //   1214: invokespecial 176	skn:<init>	(Lskk;)V
    //   1217: invokevirtual 93	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1220: pop
    //   1221: iconst_1
    //   1222: ireturn
    //   1223: invokestatic 82	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1226: new 178	skp
    //   1229: dup
    //   1230: aload_0
    //   1231: invokespecial 179	skp:<init>	(Lskk;)V
    //   1234: invokevirtual 93	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1237: pop
    //   1238: iconst_1
    //   1239: ireturn
    //   1240: new 181	skq
    //   1243: dup
    //   1244: aload_0
    //   1245: invokespecial 182	skq:<init>	(Lskk;)V
    //   1248: bipush 8
    //   1250: aconst_null
    //   1251: iconst_1
    //   1252: invokestatic 185	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1255: iconst_1
    //   1256: ireturn
    //   1257: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1260: ifeq +11 -> 1271
    //   1263: ldc 56
    //   1265: iconst_2
    //   1266: ldc 187
    //   1268: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1271: aload_0
    //   1272: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1275: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1278: invokestatic 195	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;
    //   1281: astore 10
    //   1283: aload 10
    //   1285: invokevirtual 197	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	()V
    //   1288: aload_0
    //   1289: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1292: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1295: aload 10
    //   1297: invokestatic 200	com/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/app/upgrade/UpgradeTIMWrapper;)V
    //   1300: aload_0
    //   1301: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1304: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1307: bipush 22
    //   1309: iconst_0
    //   1310: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1313: aload_0
    //   1314: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1317: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1320: bipush 22
    //   1322: aload_1
    //   1323: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1326: iconst_1
    //   1327: ireturn
    //   1328: aload_0
    //   1329: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1332: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1335: bipush 10
    //   1337: iconst_0
    //   1338: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1341: aload_0
    //   1342: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1345: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1348: bipush 10
    //   1350: aload_1
    //   1351: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1354: iconst_1
    //   1355: ireturn
    //   1356: aload_0
    //   1357: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1360: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1363: bipush 31
    //   1365: iconst_2
    //   1366: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1369: aload_0
    //   1370: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1373: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1376: bipush 31
    //   1378: aload_1
    //   1379: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1382: iconst_1
    //   1383: ireturn
    //   1384: aload_0
    //   1385: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1388: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1391: bipush 31
    //   1393: iconst_0
    //   1394: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1397: aload_0
    //   1398: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1401: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1404: bipush 31
    //   1406: aload_1
    //   1407: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1410: iconst_1
    //   1411: ireturn
    //   1412: aload_0
    //   1413: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1416: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1419: bipush 29
    //   1421: iconst_2
    //   1422: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1425: aload_0
    //   1426: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1429: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1432: bipush 29
    //   1434: aload_1
    //   1435: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1438: iconst_1
    //   1439: ireturn
    //   1440: aload_0
    //   1441: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1444: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1447: bipush 29
    //   1449: iconst_0
    //   1450: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1453: aload_0
    //   1454: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1457: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1460: bipush 29
    //   1462: aload_1
    //   1463: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1466: iconst_1
    //   1467: ireturn
    //   1468: aload_0
    //   1469: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1472: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1475: ldc 204
    //   1477: invokevirtual 208	mqq/os/MqqHandler:hasMessages	(I)Z
    //   1480: ifeq +15 -> 1495
    //   1483: aload_0
    //   1484: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1487: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1490: ldc 204
    //   1492: invokevirtual 212	mqq/os/MqqHandler:removeMessages	(I)V
    //   1495: aload_0
    //   1496: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1499: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1502: bipush 23
    //   1504: iconst_2
    //   1505: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1508: aload_0
    //   1509: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1512: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1515: bipush 23
    //   1517: aload_1
    //   1518: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1521: iconst_1
    //   1522: ireturn
    //   1523: aload_0
    //   1524: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1527: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1530: bipush 23
    //   1532: iconst_0
    //   1533: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1536: aload_0
    //   1537: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1540: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1543: bipush 23
    //   1545: aload_1
    //   1546: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1549: iconst_1
    //   1550: ireturn
    //   1551: aload_0
    //   1552: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1555: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1558: bipush 27
    //   1560: iconst_2
    //   1561: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1564: aload_0
    //   1565: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1568: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1571: bipush 27
    //   1573: aload_1
    //   1574: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1577: iconst_1
    //   1578: ireturn
    //   1579: aload_0
    //   1580: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1583: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1586: bipush 27
    //   1588: iconst_0
    //   1589: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1592: aload_0
    //   1593: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1596: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1599: bipush 27
    //   1601: aload_1
    //   1602: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1605: iconst_1
    //   1606: ireturn
    //   1607: aload_1
    //   1608: getfield 215	android/os/Message:arg1	I
    //   1611: iconst_1
    //   1612: if_icmpeq +16 -> 1628
    //   1615: aload_0
    //   1616: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1619: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1622: bipush 28
    //   1624: iconst_2
    //   1625: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1628: aload_0
    //   1629: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1632: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1635: bipush 28
    //   1637: aload_1
    //   1638: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1641: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1644: ifeq -1593 -> 51
    //   1647: ldc 217
    //   1649: iconst_2
    //   1650: ldc 219
    //   1652: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1655: iconst_1
    //   1656: ireturn
    //   1657: aload_0
    //   1658: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1661: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1664: bipush 28
    //   1666: iconst_0
    //   1667: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1670: aload_0
    //   1671: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1674: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1677: bipush 28
    //   1679: aload_1
    //   1680: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1683: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1686: ifeq -1635 -> 51
    //   1689: ldc 217
    //   1691: iconst_2
    //   1692: ldc 221
    //   1694: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1697: iconst_1
    //   1698: ireturn
    //   1699: aload_0
    //   1700: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1703: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1706: invokestatic 226	com/tencent/mobileqq/ar/config/WorldCup:a	(Lcom/tencent/common/app/AppInterface;)Lcom/tencent/mobileqq/ar/config/WorldCupConfigInfo;
    //   1709: astore_1
    //   1710: aload_0
    //   1711: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1714: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1717: sipush 152
    //   1720: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1723: checkcast 232	com/tencent/mobileqq/apollo/ApolloManager
    //   1726: astore 10
    //   1728: aload_1
    //   1729: invokestatic 237	com/tencent/mobileqq/ar/config/WorldCupConfigInfo:d	(Lcom/tencent/mobileqq/ar/config/WorldCupConfigInfo;)Z
    //   1732: ifeq +9 -> 1741
    //   1735: aload 10
    //   1737: iconst_1
    //   1738: putfield 241	com/tencent/mobileqq/apollo/ApolloManager:l	Z
    //   1741: aload_0
    //   1742: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1745: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1748: getfield 244	com/tencent/mobileqq/app/QQAppInterface:o	Z
    //   1751: ifeq +19 -> 1770
    //   1754: invokestatic 249	com/tencent/mobileqq/ar/config/WorldCupStaticInstance:a	()Lcom/tencent/mobileqq/ar/config/WorldCupStaticInstance;
    //   1757: getfield 252	com/tencent/mobileqq/ar/config/WorldCupStaticInstance:c	Z
    //   1760: ifne +10 -> 1770
    //   1763: aload_1
    //   1764: invokestatic 237	com/tencent/mobileqq/ar/config/WorldCupConfigInfo:d	(Lcom/tencent/mobileqq/ar/config/WorldCupConfigInfo;)Z
    //   1767: ifeq +19 -> 1786
    //   1770: aload 10
    //   1772: ifnull -1721 -> 51
    //   1775: aload 10
    //   1777: iconst_1
    //   1778: putfield 255	com/tencent/mobileqq/apollo/ApolloManager:k	Z
    //   1781: iconst_1
    //   1782: ireturn
    //   1783: astore_1
    //   1784: iconst_1
    //   1785: ireturn
    //   1786: invokestatic 258	com/tencent/mobileqq/app/FrameHelperActivity:a	()Z
    //   1789: ifeq +10 -> 1799
    //   1792: iconst_1
    //   1793: invokestatic 261	com/tencent/mobileqq/app/FrameHelperActivity:b	(Z)V
    //   1796: invokestatic 263	com/tencent/mobileqq/app/FrameHelperActivity:o	()V
    //   1799: aload_0
    //   1800: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1803: getfield 266	com/tencent/mobileqq/activity/Conversation:b	Landroid/widget/RelativeLayout;
    //   1806: invokestatic 271	com/tencent/mobileqq/apollo/process/CmGameUtil:a	(Landroid/view/View;)V
    //   1809: aload_0
    //   1810: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1813: iconst_1
    //   1814: putfield 274	com/tencent/mobileqq/activity/Conversation:f	Z
    //   1817: iconst_1
    //   1818: ireturn
    //   1819: aload_0
    //   1820: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1823: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar	Lcom/tencent/mobileqq/activity/recent/RecentOptPopBar;
    //   1826: ifnull -1775 -> 51
    //   1829: aload_0
    //   1830: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1833: getfield 277	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptPopBar	Lcom/tencent/mobileqq/activity/recent/RecentOptPopBar;
    //   1836: invokevirtual 281	com/tencent/mobileqq/activity/recent/RecentOptPopBar:b	()V
    //   1839: iconst_1
    //   1840: ireturn
    //   1841: aload_0
    //   1842: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1845: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1848: ldc_w 282
    //   1851: invokevirtual 208	mqq/os/MqqHandler:hasMessages	(I)Z
    //   1854: ifeq +16 -> 1870
    //   1857: aload_0
    //   1858: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1861: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1864: ldc_w 282
    //   1867: invokevirtual 212	mqq/os/MqqHandler:removeMessages	(I)V
    //   1870: aload_0
    //   1871: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1874: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1877: bipush 24
    //   1879: iconst_2
    //   1880: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1883: aload_0
    //   1884: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1887: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1890: bipush 24
    //   1892: aload_1
    //   1893: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1896: iconst_1
    //   1897: ireturn
    //   1898: aload_0
    //   1899: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1902: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1905: bipush 24
    //   1907: iconst_0
    //   1908: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1911: aload_0
    //   1912: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1915: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1918: bipush 24
    //   1920: aload_1
    //   1921: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1924: iconst_1
    //   1925: ireturn
    //   1926: aload_0
    //   1927: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1930: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1933: ldc_w 283
    //   1936: invokevirtual 208	mqq/os/MqqHandler:hasMessages	(I)Z
    //   1939: ifeq +16 -> 1955
    //   1942: aload_0
    //   1943: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1946: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1949: ldc_w 283
    //   1952: invokevirtual 212	mqq/os/MqqHandler:removeMessages	(I)V
    //   1955: aload_0
    //   1956: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1959: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1962: bipush 25
    //   1964: iconst_2
    //   1965: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1968: aload_0
    //   1969: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1972: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1975: bipush 25
    //   1977: aload_1
    //   1978: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   1981: iconst_1
    //   1982: ireturn
    //   1983: aload_0
    //   1984: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1987: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1990: bipush 25
    //   1992: iconst_0
    //   1993: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1996: aload_0
    //   1997: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2000: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2003: bipush 25
    //   2005: aload_1
    //   2006: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2009: iconst_1
    //   2010: ireturn
    //   2011: aload_0
    //   2012: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2015: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2018: ldc_w 284
    //   2021: invokevirtual 208	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2024: ifeq +16 -> 2040
    //   2027: aload_0
    //   2028: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2031: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2034: ldc_w 284
    //   2037: invokevirtual 212	mqq/os/MqqHandler:removeMessages	(I)V
    //   2040: aload_0
    //   2041: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2044: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2047: aload_1
    //   2048: invokevirtual 287	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   2051: iconst_1
    //   2052: ireturn
    //   2053: aload_0
    //   2054: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2057: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2060: bipush 26
    //   2062: iconst_0
    //   2063: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2066: aload_0
    //   2067: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2070: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2073: bipush 26
    //   2075: aload_1
    //   2076: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2079: iconst_1
    //   2080: ireturn
    //   2081: aload_0
    //   2082: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2085: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2088: bipush 6
    //   2090: iconst_2
    //   2091: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2094: aload_0
    //   2095: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2098: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2101: bipush 6
    //   2103: aload_1
    //   2104: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2107: iconst_1
    //   2108: ireturn
    //   2109: aload_0
    //   2110: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2113: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2116: bipush 6
    //   2118: iconst_0
    //   2119: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2122: aload_0
    //   2123: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2126: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2129: bipush 6
    //   2131: aload_1
    //   2132: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2135: iconst_1
    //   2136: ireturn
    //   2137: aload_1
    //   2138: getfield 215	android/os/Message:arg1	I
    //   2141: istore_2
    //   2142: aload_0
    //   2143: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2146: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2149: bipush 7
    //   2151: iload_2
    //   2152: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2155: aload_0
    //   2156: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2159: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2162: bipush 7
    //   2164: aload_1
    //   2165: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2168: iconst_1
    //   2169: ireturn
    //   2170: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2173: ifeq +12 -> 2185
    //   2176: ldc 56
    //   2178: iconst_2
    //   2179: ldc_w 289
    //   2182: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2185: aload_0
    //   2186: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2189: aload_1
    //   2190: iconst_0
    //   2191: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2194: iconst_1
    //   2195: ireturn
    //   2196: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2199: ifeq +12 -> 2211
    //   2202: ldc 56
    //   2204: iconst_2
    //   2205: ldc_w 291
    //   2208: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2211: aload_0
    //   2212: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2215: aload_1
    //   2216: iconst_1
    //   2217: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2220: iconst_1
    //   2221: ireturn
    //   2222: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2225: ifeq +12 -> 2237
    //   2228: ldc 56
    //   2230: iconst_2
    //   2231: ldc_w 293
    //   2234: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2237: aload_0
    //   2238: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2241: aload_1
    //   2242: iconst_1
    //   2243: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2246: iconst_1
    //   2247: ireturn
    //   2248: aload_0
    //   2249: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2252: aconst_null
    //   2253: iconst_1
    //   2254: invokevirtual 68	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2257: iconst_1
    //   2258: ireturn
    //   2259: aload_0
    //   2260: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2263: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2266: bipush 18
    //   2268: iconst_2
    //   2269: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2272: aload_0
    //   2273: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2276: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2279: bipush 18
    //   2281: aload_1
    //   2282: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2285: iconst_1
    //   2286: ireturn
    //   2287: aload_0
    //   2288: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2291: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2294: bipush 18
    //   2296: iconst_0
    //   2297: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2300: aload_0
    //   2301: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2304: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2307: bipush 18
    //   2309: aload_1
    //   2310: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2313: iconst_1
    //   2314: ireturn
    //   2315: aload_0
    //   2316: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2319: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2322: iconst_5
    //   2323: iconst_2
    //   2324: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2327: aload_0
    //   2328: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2331: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2334: iconst_5
    //   2335: aload_1
    //   2336: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2339: iconst_1
    //   2340: ireturn
    //   2341: aload_0
    //   2342: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2345: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2348: iconst_5
    //   2349: iconst_0
    //   2350: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2353: aload_0
    //   2354: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2357: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2360: iconst_5
    //   2361: aload_1
    //   2362: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2365: iconst_1
    //   2366: ireturn
    //   2367: aload_0
    //   2368: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2371: lconst_0
    //   2372: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   2375: iconst_1
    //   2376: ireturn
    //   2377: aload_0
    //   2378: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2381: iconst_0
    //   2382: putfield 296	com/tencent/mobileqq/activity/Conversation:j	Z
    //   2385: aload_0
    //   2386: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2389: getfield 299	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   2392: ifnull +36 -> 2428
    //   2395: aload_0
    //   2396: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2399: getfield 302	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao	Lcom/tencent/mobileqq/portal/ConversationHongBao;
    //   2402: invokevirtual 305	com/tencent/mobileqq/portal/ConversationHongBao:a	()Z
    //   2405: ifne +13 -> 2418
    //   2408: aload_0
    //   2409: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2412: getfield 299	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   2415: invokevirtual 310	com/tencent/mobileqq/fpsreport/FPSSwipListView:springBackOverScrollHeaderView	()V
    //   2418: aload_0
    //   2419: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2422: getfield 299	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   2425: invokevirtual 310	com/tencent/mobileqq/fpsreport/FPSSwipListView:springBackOverScrollHeaderView	()V
    //   2428: aload_0
    //   2429: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2432: getfield 313	com/tencent/mobileqq/activity/Conversation:c	J
    //   2435: lconst_0
    //   2436: lcmp
    //   2437: ifle +20 -> 2457
    //   2440: ldc_w 315
    //   2443: invokestatic 320	android/os/SystemClock:uptimeMillis	()J
    //   2446: aload_0
    //   2447: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2450: getfield 313	com/tencent/mobileqq/activity/Conversation:c	J
    //   2453: lsub
    //   2454: invokestatic 325	com/tencent/mobileqq/utils/StartupTracker:a	(Ljava/lang/String;J)V
    //   2457: aload_0
    //   2458: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2461: lconst_0
    //   2462: putfield 313	com/tencent/mobileqq/activity/Conversation:c	J
    //   2465: iconst_1
    //   2466: ireturn
    //   2467: aload_0
    //   2468: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2471: lconst_0
    //   2472: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   2475: iconst_1
    //   2476: ireturn
    //   2477: aload_0
    //   2478: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2481: invokevirtual 326	com/tencent/mobileqq/activity/Conversation:o	()V
    //   2484: iconst_1
    //   2485: ireturn
    //   2486: invokestatic 331	java/lang/System:currentTimeMillis	()J
    //   2489: aload_0
    //   2490: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2493: getfield 334	com/tencent/mobileqq/activity/Conversation:e	J
    //   2496: lsub
    //   2497: invokestatic 340	java/lang/Math:abs	(J)J
    //   2500: lstore 5
    //   2502: invokestatic 343	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2505: ifeq +49 -> 2554
    //   2508: ldc 56
    //   2510: iconst_4
    //   2511: new 345	java/lang/StringBuilder
    //   2514: dup
    //   2515: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   2518: ldc_w 348
    //   2521: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2524: aload_1
    //   2525: getfield 215	android/os/Message:arg1	I
    //   2528: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2531: ldc_w 357
    //   2534: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2537: lload 5
    //   2539: invokevirtual 360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2542: ldc_w 362
    //   2545: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2548: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2551: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2554: lload 5
    //   2556: lconst_0
    //   2557: lcmp
    //   2558: ifge +1158 -> 3716
    //   2561: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2564: ifeq +52 -> 2616
    //   2567: ldc 56
    //   2569: iconst_2
    //   2570: new 345	java/lang/StringBuilder
    //   2573: dup
    //   2574: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   2577: ldc_w 368
    //   2580: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2583: lload 5
    //   2585: invokevirtual 360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2588: ldc_w 357
    //   2591: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2594: aload_0
    //   2595: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2598: getfield 334	com/tencent/mobileqq/activity/Conversation:e	J
    //   2601: invokevirtual 360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2604: ldc_w 362
    //   2607: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2610: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2613: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2616: aload_0
    //   2617: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2620: getfield 370	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   2623: lconst_1
    //   2624: ladd
    //   2625: lstore 5
    //   2627: aload_1
    //   2628: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   2631: checkcast 372	java/util/List
    //   2634: astore 10
    //   2636: aload_1
    //   2637: getfield 375	android/os/Message:arg2	I
    //   2640: iconst_1
    //   2641: if_icmpeq +85 -> 2726
    //   2644: lload 5
    //   2646: aload_0
    //   2647: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2650: getfield 370	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   2653: lcmp
    //   2654: ifge +72 -> 2726
    //   2657: aload_0
    //   2658: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2661: aload 10
    //   2663: putfield 378	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2666: invokestatic 382	android/os/Message:obtain	()Landroid/os/Message;
    //   2669: astore_1
    //   2670: aload_1
    //   2671: sipush 10000
    //   2674: putfield 26	android/os/Message:what	I
    //   2677: aload_1
    //   2678: aload_0
    //   2679: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2682: getfield 378	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2685: putfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   2688: aload_1
    //   2689: iconst_0
    //   2690: putfield 215	android/os/Message:arg1	I
    //   2693: aload_1
    //   2694: iconst_1
    //   2695: putfield 375	android/os/Message:arg2	I
    //   2698: aload_0
    //   2699: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2702: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   2705: aload_1
    //   2706: aload_0
    //   2707: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2710: getfield 370	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Long	J
    //   2713: lload 5
    //   2715: lsub
    //   2716: ldc2_w 383
    //   2719: ladd
    //   2720: invokevirtual 388	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   2723: pop
    //   2724: iconst_1
    //   2725: ireturn
    //   2726: aload_1
    //   2727: getfield 375	android/os/Message:arg2	I
    //   2730: iconst_1
    //   2731: if_icmpne +53 -> 2784
    //   2734: aload 10
    //   2736: aload_0
    //   2737: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2740: getfield 378	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2743: if_acmpne +36 -> 2779
    //   2746: iconst_1
    //   2747: istore_2
    //   2748: iload_2
    //   2749: ifeq -2698 -> 51
    //   2752: aload_0
    //   2753: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2756: iconst_0
    //   2757: aload_0
    //   2758: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2761: getfield 378	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2764: invokevirtual 391	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   2767: aload_0
    //   2768: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2771: invokestatic 331	java/lang/System:currentTimeMillis	()J
    //   2774: putfield 334	com/tencent/mobileqq/activity/Conversation:e	J
    //   2777: iconst_1
    //   2778: ireturn
    //   2779: iconst_0
    //   2780: istore_2
    //   2781: goto -33 -> 2748
    //   2784: aload_0
    //   2785: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2788: aload 10
    //   2790: putfield 378	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   2793: iconst_1
    //   2794: istore_2
    //   2795: goto -47 -> 2748
    //   2798: aload_1
    //   2799: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   2802: checkcast 372	java/util/List
    //   2805: astore_1
    //   2806: aload_0
    //   2807: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2810: iconst_1
    //   2811: aload_1
    //   2812: invokevirtual 391	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   2815: iconst_1
    //   2816: ireturn
    //   2817: aload_0
    //   2818: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2821: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2824: ifnull -2773 -> 51
    //   2827: aload_0
    //   2828: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2831: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2834: iconst_1
    //   2835: iconst_0
    //   2836: invokevirtual 394	com/tencent/mobileqq/app/QQAppInterface:a	(ZI)V
    //   2839: iconst_1
    //   2840: ireturn
    //   2841: aload_0
    //   2842: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2845: invokestatic 396	com/tencent/mobileqq/activity/Conversation:c	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   2848: iconst_1
    //   2849: ireturn
    //   2850: aload_0
    //   2851: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2854: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2857: astore 10
    //   2859: iload_3
    //   2860: istore_2
    //   2861: aload_0
    //   2862: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2865: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2868: invokevirtual 399	com/tencent/mobileqq/app/QQAppInterface:a	()Lcooperation/qlink/QQProxyForQlink;
    //   2871: invokevirtual 404	cooperation/qlink/QQProxyForQlink:a	()I
    //   2874: ifeq +5 -> 2879
    //   2877: iconst_2
    //   2878: istore_2
    //   2879: aload 10
    //   2881: bipush 33
    //   2883: iload_2
    //   2884: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2887: aload_0
    //   2888: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2891: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2894: bipush 33
    //   2896: aload_1
    //   2897: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2900: iconst_1
    //   2901: ireturn
    //   2902: aload_0
    //   2903: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2906: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2909: astore 10
    //   2911: invokestatic 409	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	()Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   2914: invokevirtual 410	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	()Z
    //   2917: ifeq +26 -> 2943
    //   2920: aload 10
    //   2922: bipush 34
    //   2924: iload_2
    //   2925: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2928: aload_0
    //   2929: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2932: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2935: bipush 34
    //   2937: aload_1
    //   2938: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2941: iconst_1
    //   2942: ireturn
    //   2943: iconst_0
    //   2944: istore_2
    //   2945: goto -25 -> 2920
    //   2948: aload_0
    //   2949: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2952: invokevirtual 413	com/tencent/mobileqq/activity/Conversation:t	()V
    //   2955: iconst_1
    //   2956: ireturn
    //   2957: aload_0
    //   2958: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2961: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2964: bipush 20
    //   2966: iconst_2
    //   2967: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2970: aload_0
    //   2971: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2974: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2977: bipush 20
    //   2979: aload_1
    //   2980: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   2983: iconst_1
    //   2984: ireturn
    //   2985: aload_0
    //   2986: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   2989: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   2992: bipush 20
    //   2994: iconst_0
    //   2995: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   2998: aload_0
    //   2999: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3002: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3005: bipush 20
    //   3007: aload_1
    //   3008: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   3011: iconst_1
    //   3012: ireturn
    //   3013: aload_0
    //   3014: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3017: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3020: bipush 21
    //   3022: iconst_2
    //   3023: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   3026: aload_0
    //   3027: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3030: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3033: bipush 21
    //   3035: aload_1
    //   3036: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   3039: iconst_1
    //   3040: ireturn
    //   3041: aload_0
    //   3042: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3045: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3048: bipush 21
    //   3050: iconst_0
    //   3051: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   3054: aload_0
    //   3055: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3058: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3061: bipush 21
    //   3063: aload_1
    //   3064: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   3067: iconst_1
    //   3068: ireturn
    //   3069: aload_0
    //   3070: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3073: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3076: iconst_4
    //   3077: aload_1
    //   3078: getfield 215	android/os/Message:arg1	I
    //   3081: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   3084: aload_0
    //   3085: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3088: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3091: iconst_4
    //   3092: aload_1
    //   3093: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   3096: iconst_1
    //   3097: ireturn
    //   3098: aload_0
    //   3099: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3102: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   3105: ifnull -3054 -> 51
    //   3108: aload_0
    //   3109: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3112: getfield 416	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter	Lcom/tencent/mobileqq/activity/recent/RecentAdapter;
    //   3115: invokevirtual 419	com/tencent/mobileqq/activity/recent/RecentAdapter:a	()V
    //   3118: iconst_1
    //   3119: ireturn
    //   3120: aload_0
    //   3121: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3124: getfield 422	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3127: ifnull -3076 -> 51
    //   3130: aload_1
    //   3131: getfield 215	android/os/Message:arg1	I
    //   3134: iconst_1
    //   3135: if_icmpne +38 -> 3173
    //   3138: iconst_1
    //   3139: istore_2
    //   3140: iload_2
    //   3141: ifeq +37 -> 3178
    //   3144: new 424	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   3147: dup
    //   3148: invokespecial 425	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   3151: astore_1
    //   3152: aload_1
    //   3153: getfield 429	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3156: iconst_0
    //   3157: invokevirtual 434	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3160: aload_0
    //   3161: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3164: getfield 422	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3167: aload_1
    //   3168: invokevirtual 439	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   3171: iconst_1
    //   3172: ireturn
    //   3173: iconst_0
    //   3174: istore_2
    //   3175: goto -35 -> 3140
    //   3178: aload_0
    //   3179: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3182: getfield 422	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3185: new 441	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   3188: dup
    //   3189: invokespecial 442	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   3192: invokevirtual 445	com/tencent/mobileqq/redtouch/RedTouch:a	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   3195: iconst_1
    //   3196: ireturn
    //   3197: aload_0
    //   3198: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3201: getfield 299	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3204: ifnull -3153 -> 51
    //   3207: aload_0
    //   3208: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3211: getfield 448	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3214: ifnull -3163 -> 51
    //   3217: aload_1
    //   3218: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3221: instanceof 450
    //   3224: ifeq -3173 -> 51
    //   3227: aload_1
    //   3228: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3231: checkcast 450	com/tencent/mobileqq/theme/diy/ThemeBackground
    //   3234: astore_1
    //   3235: ldc_w 452
    //   3238: aload_1
    //   3239: getfield 456	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   3242: invokevirtual 462	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3245: ifne +70 -> 3315
    //   3248: aload_1
    //   3249: getfield 466	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   3252: ifnull +63 -> 3315
    //   3255: invokestatic 471	com/tencent/mobileqq/theme/ThemeUtil:isNowThemeIsDIY	()Z
    //   3258: ifeq +30 -> 3288
    //   3261: aload_0
    //   3262: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3265: getfield 299	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3268: aload_1
    //   3269: getfield 466	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   3272: invokevirtual 475	com/tencent/mobileqq/fpsreport/FPSSwipListView:setContentBackground	(Landroid/graphics/drawable/Drawable;)V
    //   3275: aload_0
    //   3276: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3279: getfield 448	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3282: aconst_null
    //   3283: invokevirtual 480	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3286: iconst_1
    //   3287: ireturn
    //   3288: aload_0
    //   3289: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3292: getfield 299	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3295: aconst_null
    //   3296: invokevirtual 475	com/tencent/mobileqq/fpsreport/FPSSwipListView:setContentBackground	(Landroid/graphics/drawable/Drawable;)V
    //   3299: aload_0
    //   3300: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3303: getfield 448	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3306: aload_1
    //   3307: getfield 466	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   3310: invokevirtual 480	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3313: iconst_1
    //   3314: ireturn
    //   3315: aload_0
    //   3316: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3319: getfield 299	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView	Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3322: ldc_w 481
    //   3325: invokevirtual 483	com/tencent/mobileqq/fpsreport/FPSSwipListView:setContentBackground	(I)V
    //   3328: aload_0
    //   3329: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3332: getfield 448	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidViewView	Landroid/view/View;
    //   3335: aconst_null
    //   3336: invokevirtual 480	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   3339: iconst_1
    //   3340: ireturn
    //   3341: aload_0
    //   3342: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3345: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3348: astore 10
    //   3350: aload_1
    //   3351: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3354: ifnonnull +27 -> 3381
    //   3357: iload 4
    //   3359: istore_2
    //   3360: aload 10
    //   3362: iconst_2
    //   3363: iload_2
    //   3364: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   3367: aload_0
    //   3368: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3371: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3374: iconst_2
    //   3375: aload_1
    //   3376: invokevirtual 73	com/tencent/mobileqq/activity/recent/BannerManager:a	(ILandroid/os/Message;)V
    //   3379: iconst_1
    //   3380: ireturn
    //   3381: iconst_2
    //   3382: istore_2
    //   3383: goto -23 -> 3360
    //   3386: aload_0
    //   3387: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3390: invokestatic 76	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3393: iconst_1
    //   3394: ireturn
    //   3395: aload_0
    //   3396: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3399: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3402: bipush 10
    //   3404: invokevirtual 486	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3407: checkcast 488	com/tencent/mobileqq/app/RegisterProxySvcPackHandler
    //   3410: invokevirtual 490	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:c	()V
    //   3413: iconst_1
    //   3414: ireturn
    //   3415: aload_0
    //   3416: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3419: getfield 493	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity	Lcom/tencent/mobileqq/app/FrameHelperActivity;
    //   3422: getfield 496	com/tencent/mobileqq/app/FrameHelperActivity:a	Landroid/widget/ImageView;
    //   3425: astore_1
    //   3426: aload_0
    //   3427: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3430: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3433: sipush 249
    //   3436: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3439: checkcast 498	com/tencent/mobileqq/medalwall/MedalWallMng
    //   3442: aload_0
    //   3443: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3446: invokevirtual 501	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   3449: aload_1
    //   3450: iconst_1
    //   3451: aconst_null
    //   3452: invokevirtual 504	com/tencent/mobileqq/medalwall/MedalWallMng:a	(Lcom/tencent/mobileqq/app/BaseActivity;Landroid/view/View;ILjava/lang/Object;)Z
    //   3455: istore 9
    //   3457: invokestatic 343	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3460: ifeq -3409 -> 51
    //   3463: ldc_w 506
    //   3466: iconst_4
    //   3467: invokestatic 512	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   3470: ldc_w 514
    //   3473: iconst_1
    //   3474: anewarray 4	java/lang/Object
    //   3477: dup
    //   3478: iconst_0
    //   3479: iload 9
    //   3481: invokestatic 520	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3484: aastore
    //   3485: invokestatic 524	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3488: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3491: iconst_1
    //   3492: ireturn
    //   3493: ldc 56
    //   3495: ldc_w 526
    //   3498: invokestatic 531	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   3501: aload_0
    //   3502: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3505: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3508: ifnull +20 -> 3528
    //   3511: aload_0
    //   3512: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3515: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3518: sipush 180
    //   3521: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3524: checkcast 533	com/tencent/biz/qqstory/base/QQStoryManager
    //   3527: astore_1
    //   3528: new 535	sks
    //   3531: dup
    //   3532: aload_0
    //   3533: invokespecial 536	sks:<init>	(Lskk;)V
    //   3536: bipush 8
    //   3538: aconst_null
    //   3539: iconst_1
    //   3540: invokestatic 185	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   3543: iconst_1
    //   3544: ireturn
    //   3545: aload_0
    //   3546: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3549: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3552: invokevirtual 538	com/tencent/mobileqq/activity/recent/BannerManager:a	()Lmqq/os/MqqHandler;
    //   3555: astore 10
    //   3557: aload 10
    //   3559: ifnull -3508 -> 51
    //   3562: aload 10
    //   3564: sipush 200
    //   3567: invokevirtual 542	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   3570: astore 11
    //   3572: aload 11
    //   3574: aload_1
    //   3575: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3578: putfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3581: aload 10
    //   3583: aload 11
    //   3585: invokevirtual 545	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   3588: pop
    //   3589: iconst_1
    //   3590: ireturn
    //   3591: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3594: ifeq +30 -> 3624
    //   3597: ldc_w 547
    //   3600: iconst_2
    //   3601: new 345	java/lang/StringBuilder
    //   3604: dup
    //   3605: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   3608: ldc_w 549
    //   3611: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3614: aload_1
    //   3615: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3618: invokevirtual 366	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3621: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3624: aload_0
    //   3625: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3628: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   3631: invokevirtual 538	com/tencent/mobileqq/activity/recent/BannerManager:a	()Lmqq/os/MqqHandler;
    //   3634: astore 10
    //   3636: aload 10
    //   3638: ifnull -3587 -> 51
    //   3641: aload 10
    //   3643: sipush 201
    //   3646: invokevirtual 542	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   3649: astore 11
    //   3651: aload 11
    //   3653: aload_1
    //   3654: getfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3657: putfield 152	android/os/Message:obj	Ljava/lang/Object;
    //   3660: aload 10
    //   3662: aload 11
    //   3664: invokevirtual 545	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   3667: pop
    //   3668: iconst_1
    //   3669: ireturn
    //   3670: aload_0
    //   3671: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3674: getfield 554	com/tencent/mobileqq/activity/Conversation:i	Z
    //   3677: ifeq -3626 -> 51
    //   3680: aload_0
    //   3681: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3684: getfield 203	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3687: ldc_w 555
    //   3690: getstatic 559	com/tencent/mobileqq/statistics/QZoneReport:a	I
    //   3693: sipush 1000
    //   3696: imul
    //   3697: i2l
    //   3698: invokevirtual 563	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   3701: pop
    //   3702: iconst_1
    //   3703: ireturn
    //   3704: aload_0
    //   3705: getfield 12	skk:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   3708: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3711: invokestatic 566	com/tencent/mobileqq/statistics/QZoneReport:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   3714: iconst_1
    //   3715: ireturn
    //   3716: goto -1089 -> 2627
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3719	0	this	skk
    //   0	3719	1	paramMessage	android.os.Message
    //   1	3382	2	i	int
    //   6	2854	3	j	int
    //   3	3355	4	k	int
    //   829	1885	5	l1	long
    //   841	216	7	l2	long
    //   3455	25	9	bool	boolean
    //   797	183	10	localUpgradeDetailWrapper	com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper
    //   1160	1	10	localException	java.lang.Exception
    //   1281	2380	10	localObject1	Object
    //   817	2846	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1113	1123	1160	java/lang/Exception
    //   1113	1123	1174	finally
    //   1699	1741	1783	java/lang/Exception
    //   1741	1770	1783	java/lang/Exception
    //   1775	1781	1783	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     skk
 * JD-Core Version:    0.7.0.1
 */