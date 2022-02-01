package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.World;
import org.jbox2d.pooling.IWorldPool;

public abstract class Joint
{
  protected Body m_bodyA;
  protected Body m_bodyB;
  private boolean m_collideConnected;
  public JointEdge m_edgeA;
  public JointEdge m_edgeB;
  public boolean m_islandFlag;
  public Joint m_next;
  public Joint m_prev;
  private final JointType m_type;
  public Object m_userData;
  protected IWorldPool pool;
  
  protected Joint(IWorldPool paramIWorldPool, JointDef paramJointDef)
  {
    this.pool = paramIWorldPool;
    this.m_type = paramJointDef.type;
    this.m_prev = null;
    this.m_next = null;
    this.m_bodyA = paramJointDef.bodyA;
    this.m_bodyB = paramJointDef.bodyB;
    this.m_collideConnected = paramJointDef.collideConnected;
    this.m_islandFlag = false;
    this.m_userData = paramJointDef.userData;
    this.m_edgeA = new JointEdge();
    paramIWorldPool = this.m_edgeA;
    paramIWorldPool.joint = null;
    paramIWorldPool.other = null;
    paramIWorldPool.prev = null;
    paramIWorldPool.next = null;
    this.m_edgeB = new JointEdge();
    paramIWorldPool = this.m_edgeB;
    paramIWorldPool.joint = null;
    paramIWorldPool.other = null;
    paramIWorldPool.prev = null;
    paramIWorldPool.next = null;
  }
  
  public static Joint create(World paramWorld, JointDef paramJointDef)
  {
    switch (Joint.1.$SwitchMap$org$jbox2d$dynamics$joints$JointType[paramJointDef.type.ordinal()])
    {
    default: 
      return null;
    case 11: 
      return new RopeJoint(paramWorld.getPool(), (RopeJointDef)paramJointDef);
    case 10: 
      return new ConstantVolumeJoint(paramWorld, (ConstantVolumeJointDef)paramJointDef);
    case 9: 
      return new PulleyJoint(paramWorld.getPool(), (PulleyJointDef)paramJointDef);
    case 8: 
      return new GearJoint(paramWorld.getPool(), (GearJointDef)paramJointDef);
    case 7: 
      return new WheelJoint(paramWorld.getPool(), (WheelJointDef)paramJointDef);
    case 6: 
      return new FrictionJoint(paramWorld.getPool(), (FrictionJointDef)paramJointDef);
    case 5: 
      return new WeldJoint(paramWorld.getPool(), (WeldJointDef)paramJointDef);
    case 4: 
      return new RevoluteJoint(paramWorld.getPool(), (RevoluteJointDef)paramJointDef);
    case 3: 
      return new PrismaticJoint(paramWorld.getPool(), (PrismaticJointDef)paramJointDef);
    case 2: 
      return new DistanceJoint(paramWorld.getPool(), (DistanceJointDef)paramJointDef);
    }
    return new MouseJoint(paramWorld.getPool(), (MouseJointDef)paramJointDef);
  }
  
  public static void destroy(Joint paramJoint)
  {
    paramJoint.destructor();
  }
  
  public void destructor() {}
  
  public abstract void getAnchorA(Vec2 paramVec2);
  
  public abstract void getAnchorB(Vec2 paramVec2);
  
  public final Body getBodyA()
  {
    return this.m_bodyA;
  }
  
  public final Body getBodyB()
  {
    return this.m_bodyB;
  }
  
  public final boolean getCollideConnected()
  {
    return this.m_collideConnected;
  }
  
  public Joint getNext()
  {
    return this.m_next;
  }
  
  public abstract void getReactionForce(float paramFloat, Vec2 paramVec2);
  
  public abstract float getReactionTorque(float paramFloat);
  
  public JointType getType()
  {
    return this.m_type;
  }
  
  public Object getUserData()
  {
    return this.m_userData;
  }
  
  public abstract void initVelocityConstraints(SolverData paramSolverData);
  
  public boolean isActive()
  {
    return (this.m_bodyA.isActive()) && (this.m_bodyB.isActive());
  }
  
  public void setUserData(Object paramObject)
  {
    this.m_userData = paramObject;
  }
  
  public abstract boolean solvePositionConstraints(SolverData paramSolverData);
  
  public abstract void solveVelocityConstraints(SolverData paramSolverData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.Joint
 * JD-Core Version:    0.7.0.1
 */