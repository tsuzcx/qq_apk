package org.jbox2d.dynamics.joints;

import java.util.ArrayList;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

public class ConstantVolumeJoint
  extends Joint
{
  private final Body[] bodies;
  private DistanceJoint[] distanceJoints;
  private float m_impulse = 0.0F;
  private Vec2[] normals;
  private float[] targetLengths;
  private float targetVolume;
  private World world;
  
  public ConstantVolumeJoint(World paramWorld, ConstantVolumeJointDef paramConstantVolumeJointDef)
  {
    super(paramWorld.getPool(), paramConstantVolumeJointDef);
    this.world = paramWorld;
    if (paramConstantVolumeJointDef.bodies.size() > 2)
    {
      paramWorld = paramConstantVolumeJointDef.bodies;
      int k = 0;
      this.bodies = ((Body[])paramWorld.toArray(new Body[0]));
      this.targetLengths = new float[this.bodies.length];
      int i = 0;
      int j;
      for (;;)
      {
        paramWorld = this.targetLengths;
        if (i >= paramWorld.length) {
          break;
        }
        if (i == paramWorld.length - 1) {
          j = 0;
        } else {
          j = i + 1;
        }
        float f = this.bodies[i].getWorldCenter().sub(this.bodies[j].getWorldCenter()).length();
        this.targetLengths[i] = f;
        i += 1;
      }
      this.targetVolume = getBodyArea();
      if ((paramConstantVolumeJointDef.joints != null) && (paramConstantVolumeJointDef.joints.size() != paramConstantVolumeJointDef.bodies.size())) {
        throw new IllegalArgumentException("Incorrect joint definition.  Joints have to correspond to the bodies");
      }
      if (paramConstantVolumeJointDef.joints == null)
      {
        paramWorld = new DistanceJointDef();
        this.distanceJoints = new DistanceJoint[this.bodies.length];
        i = 0;
        for (;;)
        {
          Object localObject = this.targetLengths;
          if (i >= localObject.length) {
            break;
          }
          if (i == localObject.length - 1) {
            j = 0;
          } else {
            j = i + 1;
          }
          paramWorld.frequencyHz = paramConstantVolumeJointDef.frequencyHz;
          paramWorld.dampingRatio = paramConstantVolumeJointDef.dampingRatio;
          paramWorld.collideConnected = paramConstantVolumeJointDef.collideConnected;
          localObject = this.bodies;
          paramWorld.initialize(localObject[i], localObject[j], localObject[i].getWorldCenter(), this.bodies[j].getWorldCenter());
          this.distanceJoints[i] = ((DistanceJoint)this.world.createJoint(paramWorld));
          i += 1;
        }
      }
      this.distanceJoints = ((DistanceJoint[])paramConstantVolumeJointDef.joints.toArray(new DistanceJoint[0]));
      this.normals = new Vec2[this.bodies.length];
      i = k;
      for (;;)
      {
        paramWorld = this.normals;
        if (i >= paramWorld.length) {
          break;
        }
        paramWorld[i] = new Vec2();
        i += 1;
      }
      return;
    }
    paramWorld = new IllegalArgumentException("You cannot create a constant volume joint with less than three bodies.");
    for (;;)
    {
      throw paramWorld;
    }
  }
  
  private boolean constrainEdges(Position[] paramArrayOfPosition)
  {
    int i = 0;
    float f1 = 0.0F;
    int j;
    float f2;
    for (;;)
    {
      localObject1 = this.bodies;
      if (i >= localObject1.length) {
        break;
      }
      if (i == localObject1.length - 1) {
        j = 0;
      } else {
        j = i + 1;
      }
      float f4 = paramArrayOfPosition[this.bodies[j].m_islandIndex].c.x - paramArrayOfPosition[this.bodies[i].m_islandIndex].c.x;
      float f5 = paramArrayOfPosition[this.bodies[j].m_islandIndex].c.y - paramArrayOfPosition[this.bodies[i].m_islandIndex].c.y;
      float f3 = MathUtils.sqrt(f4 * f4 + f5 * f5);
      f2 = f3;
      if (f3 < 1.192093E-007F) {
        f2 = 1.0F;
      }
      localObject1 = this.normals;
      localObject1[i].x = (f5 / f2);
      localObject1[i].y = (-f4 / f2);
      f1 += f2;
      i += 1;
    }
    Object localObject1 = this.pool.popVec2();
    f1 = (this.targetVolume - getSolverArea(paramArrayOfPosition)) * 0.5F / f1;
    i = 0;
    boolean bool = true;
    for (;;)
    {
      Object localObject2 = this.bodies;
      if (i >= localObject2.length) {
        break;
      }
      if (i == localObject2.length - 1) {
        j = 0;
      } else {
        j = i + 1;
      }
      ((Vec2)localObject1).set((this.normals[i].x + this.normals[j].x) * f1, (this.normals[i].y + this.normals[j].y) * f1);
      f2 = ((Vec2)localObject1).lengthSquared();
      if (f2 > 0.04F) {
        ((Vec2)localObject1).mulLocal(0.2F / MathUtils.sqrt(f2));
      }
      if (f2 > 2.5E-005F) {
        bool = false;
      }
      localObject2 = paramArrayOfPosition[this.bodies[j].m_islandIndex].c;
      ((Vec2)localObject2).x += ((Vec2)localObject1).x;
      localObject2 = paramArrayOfPosition[this.bodies[j].m_islandIndex].c;
      ((Vec2)localObject2).y += ((Vec2)localObject1).y;
      i += 1;
    }
    this.pool.pushVec2(1);
    return bool;
  }
  
  private float getBodyArea()
  {
    int i = 0;
    float f = 0.0F;
    for (;;)
    {
      Body[] arrayOfBody = this.bodies;
      if (i >= arrayOfBody.length - 1) {
        break;
      }
      int j;
      if (i == arrayOfBody.length - 1) {
        j = 0;
      } else {
        j = i + 1;
      }
      f += this.bodies[i].getWorldCenter().x * this.bodies[j].getWorldCenter().y - this.bodies[j].getWorldCenter().x * this.bodies[i].getWorldCenter().y;
      i += 1;
    }
    return f * 0.5F;
  }
  
  private float getSolverArea(Position[] paramArrayOfPosition)
  {
    int i = 0;
    float f = 0.0F;
    for (;;)
    {
      Body[] arrayOfBody = this.bodies;
      if (i >= arrayOfBody.length) {
        break;
      }
      int j;
      if (i == arrayOfBody.length - 1) {
        j = 0;
      } else {
        j = i + 1;
      }
      f += paramArrayOfPosition[this.bodies[i].m_islandIndex].c.x * paramArrayOfPosition[this.bodies[j].m_islandIndex].c.y - paramArrayOfPosition[this.bodies[j].m_islandIndex].c.x * paramArrayOfPosition[this.bodies[i].m_islandIndex].c.y;
      i += 1;
    }
    return f * 0.5F;
  }
  
  public void destructor()
  {
    int i = 0;
    for (;;)
    {
      DistanceJoint[] arrayOfDistanceJoint = this.distanceJoints;
      if (i >= arrayOfDistanceJoint.length) {
        break;
      }
      this.world.destroyJoint(arrayOfDistanceJoint[i]);
      i += 1;
    }
  }
  
  public void getAnchorA(Vec2 paramVec2) {}
  
  public void getAnchorB(Vec2 paramVec2) {}
  
  public Body[] getBodies()
  {
    return this.bodies;
  }
  
  public DistanceJoint[] getJoints()
  {
    return this.distanceJoints;
  }
  
  public void getReactionForce(float paramFloat, Vec2 paramVec2) {}
  
  public float getReactionTorque(float paramFloat)
  {
    return 0.0F;
  }
  
  public void inflate(float paramFloat)
  {
    this.targetVolume *= paramFloat;
  }
  
  public void initVelocityConstraints(SolverData paramSolverData)
  {
    Velocity[] arrayOfVelocity = paramSolverData.velocities;
    Position[] arrayOfPosition = paramSolverData.positions;
    Vec2[] arrayOfVec2 = this.pool.getVec2Array(this.bodies.length);
    int m = 0;
    int i = 0;
    for (;;)
    {
      Body[] arrayOfBody = this.bodies;
      if (i >= arrayOfBody.length) {
        break;
      }
      int j;
      if (i == 0) {
        j = arrayOfBody.length - 1;
      } else {
        j = i - 1;
      }
      int k;
      if (i == this.bodies.length - 1) {
        k = 0;
      } else {
        k = i + 1;
      }
      arrayOfVec2[i].set(arrayOfPosition[this.bodies[k].m_islandIndex].c);
      arrayOfVec2[i].subLocal(arrayOfPosition[this.bodies[j].m_islandIndex].c);
      i += 1;
    }
    if (paramSolverData.step.warmStarting)
    {
      this.m_impulse *= paramSolverData.step.dtRatio;
      i = m;
      for (;;)
      {
        paramSolverData = this.bodies;
        if (i >= paramSolverData.length) {
          break;
        }
        paramSolverData = arrayOfVelocity[paramSolverData[i].m_islandIndex].v;
        paramSolverData.x += this.bodies[i].m_invMass * arrayOfVec2[i].y * 0.5F * this.m_impulse;
        paramSolverData = arrayOfVelocity[this.bodies[i].m_islandIndex].v;
        paramSolverData.y += this.bodies[i].m_invMass * -arrayOfVec2[i].x * 0.5F * this.m_impulse;
        i += 1;
      }
    }
    this.m_impulse = 0.0F;
  }
  
  public boolean solvePositionConstraints(SolverData paramSolverData)
  {
    return constrainEdges(paramSolverData.positions);
  }
  
  public void solveVelocityConstraints(SolverData paramSolverData)
  {
    Velocity[] arrayOfVelocity = paramSolverData.velocities;
    Object localObject = paramSolverData.positions;
    paramSolverData = this.pool.getVec2Array(this.bodies.length);
    int m = 0;
    int i = 0;
    float f1 = 0.0F;
    float f2 = 0.0F;
    for (;;)
    {
      Body[] arrayOfBody = this.bodies;
      if (i >= arrayOfBody.length) {
        break;
      }
      int j;
      if (i == 0) {
        j = arrayOfBody.length - 1;
      } else {
        j = i - 1;
      }
      int k;
      if (i == this.bodies.length - 1) {
        k = 0;
      } else {
        k = i + 1;
      }
      paramSolverData[i].set(localObject[this.bodies[k].m_islandIndex].c);
      paramSolverData[i].subLocal(localObject[this.bodies[j].m_islandIndex].c);
      f2 += paramSolverData[i].lengthSquared() / this.bodies[i].getMass();
      f1 += Vec2.cross(arrayOfVelocity[this.bodies[i].m_islandIndex].v, paramSolverData[i]);
      i += 1;
    }
    f1 = f1 * -2.0F / f2;
    this.m_impulse += f1;
    i = m;
    for (;;)
    {
      localObject = this.bodies;
      if (i >= localObject.length) {
        break;
      }
      localObject = arrayOfVelocity[localObject[i].m_islandIndex].v;
      ((Vec2)localObject).x += this.bodies[i].m_invMass * paramSolverData[i].y * 0.5F * f1;
      localObject = arrayOfVelocity[this.bodies[i].m_islandIndex].v;
      ((Vec2)localObject).y += this.bodies[i].m_invMass * -paramSolverData[i].x * 0.5F * f1;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.joints.ConstantVolumeJoint
 * JD-Core Version:    0.7.0.1
 */